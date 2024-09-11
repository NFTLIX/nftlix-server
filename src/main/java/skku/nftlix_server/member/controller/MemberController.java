package skku.nftlix_server.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skku.nftlix_server.member.dto.request.SignUpRequest;
import skku.nftlix_server.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest request) {
        memberService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("member created successfully");
    }
}
