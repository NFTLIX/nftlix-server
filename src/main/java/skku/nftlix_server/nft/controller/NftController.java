package skku.nftlix_server.nft.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skku.nftlix_server.member.service.MemberService;
import skku.nftlix_server.nft.dto.request.NftRequest;
import skku.nftlix_server.nft.dto.response.NftResponse;
import skku.nftlix_server.nft.service.NftService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nft")
@Slf4j
public class NftController {

    private final NftService nftService;
    private final MemberService memberService;

    @PostMapping
    public NftResponse createNft(@RequestPart NftRequest nftRequest,
                                 @RequestPart MultipartFile image,
                                 HttpServletRequest request) throws IOException {

        return nftService.createNft(nftRequest, image, memberService.getLoginMember(request));
    }
}
