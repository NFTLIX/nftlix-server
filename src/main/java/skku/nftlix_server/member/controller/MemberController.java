package skku.nftlix_server.member.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skku.nftlix_server.member.dto.request.LoginRequest;
import skku.nftlix_server.member.dto.request.SignUpRequest;
import skku.nftlix_server.member.dto.response.LoginResponse;
import skku.nftlix_server.member.dto.response.MemberResponse;
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
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request, HttpServletResponse response) {
        return memberService.login(request, response);
    }

    @GetMapping("/login")
    public MemberResponse getLoginMember(@RequestParam String id) {
        return MemberResponse.of(memberService.getLoginMember(id));
    }
}
