package skku.nftlix_server.nft.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skku.nftlix_server.member.service.MemberService;
import skku.nftlix_server.nft.dto.request.NftMintRequest;
import skku.nftlix_server.nft.dto.request.NftRequest;
import skku.nftlix_server.nft.dto.response.NftResponse;
import skku.nftlix_server.nft.dto.response.SingleNftResponse;
import skku.nftlix_server.nft.service.NftService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nfts")
@Slf4j
public class NftController {

    private final NftService nftService;
    private final MemberService memberService;

    @PostMapping
    public NftResponse createNft(@RequestPart NftRequest nftRequest,
                                 @RequestPart MultipartFile image) throws IOException {

        return nftService.createNft(nftRequest, image, memberService.getLoginMember(nftRequest.memberId()));
    }

    @GetMapping
    public List<SingleNftResponse> findAllNft() {

        return nftService.findAllNft();
    }

    @GetMapping("/{id}")
    public SingleNftResponse findNft(@PathVariable String id) {

        return nftService.findSingleNft(id);
    }

    @PostMapping("/mint")
    public ResponseEntity<String> mint(@RequestBody NftMintRequest request) {

        nftService.mint(request.id());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("nft minted successfully");
    }
}
