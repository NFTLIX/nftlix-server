package skku.nftlix_server.nft.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import skku.nftlix_server.member.Member;
import skku.nftlix_server.member.exception.MemberNotFoundException;
import skku.nftlix_server.member.repository.MemberRepository;
import skku.nftlix_server.nft.Nft;
import skku.nftlix_server.nft.dto.request.NftRequest;
import skku.nftlix_server.nft.dto.response.ImageResponse;
import skku.nftlix_server.nft.dto.response.MultipleNftResponse;
import skku.nftlix_server.nft.dto.response.NftResponse;
import skku.nftlix_server.nft.dto.response.SingleNftResponse;
import skku.nftlix_server.nft.exception.ImageServerException;
import skku.nftlix_server.nft.exception.NftNotFoundException;
import skku.nftlix_server.nft.repository.NftRepository;
import skku.nftlix_server.util.BashService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NftService {

    private final NftRepository nftRepository;
    private final MemberRepository memberRepository;
    private final BashService bashService;
    private final RestTemplate restTemplate = new RestTemplate();

    private final String NODE_COMMAND = "node";
    private final String NFT_MINT_DIRECTORY = "/app/nftlix-nft-mint/";
    private final String NFT_MINT_FILE = "scripts/mint-nft.js";


    public NftResponse createNft(NftRequest request, MultipartFile image, Member member) throws IOException {

        String id = UUID.randomUUID().toString();
        String apiUrl = "https://ai.nftlix.store/api/v1/" + request.filter() + '/';

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 이미지 파일을 MultipartBody에 추가
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", new org.springframework.core.io.ByteArrayResource(image.getBytes()) {
            @Override
            public String getFilename() {
                return image.getOriginalFilename(); // 파일명 설정
            }
        });
        body.add("description", request.description());
        body.add("name", request.name());
        body.add("token_id", id);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // API로 POST 요청 전송
        ResponseEntity<ImageResponse> response
                = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ImageResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            ImageResponse responseBody = response.getBody();
            return new NftResponse(nftRepository.save(Nft.createNft(
                    id,
                    member.getId(),
                    request.name(),
                    request.description(),
                    request.price(),
                    request.royalty(),
                    request.privilege(),
                    responseBody.convertedImageUrl(),
                    responseBody.originalImageUrl(),
                    responseBody.metadataUrl())
            ).getId());
        } else {
            throw new ImageServerException();
        }
    }

    public void mint(String id) {
        String metadataUrl =
                nftRepository.findById(id).orElseThrow(() -> new NftNotFoundException(id)).getMetadataUrl();

        List<String> generateNFTCommand =
                Arrays.asList("/bin/sh",
                        "-c",
                        bashService.makeCommand(Arrays.asList(
                                "cd",
                                NFT_MINT_DIRECTORY,
                                "&&",
                                NODE_COMMAND,
                                NFT_MINT_FILE,
                                metadataUrl)));

        bashService.executeCommand(generateNFTCommand);
    }

    public List<MultipleNftResponse> findAllNft() {

        return nftRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(MultipleNftResponse::of)
                .toList();
    }

    public SingleNftResponse findSingleNft(String id) {

        Nft findNft = nftRepository.findById(id).orElseThrow(() -> new NftNotFoundException(id));

        return SingleNftResponse.of(
                findNft,
                memberRepository.findById(findNft.getMemberId())
                        .orElseThrow(() -> new MemberNotFoundException(findNft.getMemberId()))
        );
    }
}
