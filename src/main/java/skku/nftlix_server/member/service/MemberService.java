package skku.nftlix_server.member.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import skku.nftlix_server.member.Member;
import skku.nftlix_server.member.dto.request.LoginRequest;
import skku.nftlix_server.member.dto.request.SignUpRequest;
import skku.nftlix_server.member.dto.response.LoginResponse;
import skku.nftlix_server.member.exception.LoginIdAlreadyExistsException;
import skku.nftlix_server.member.exception.MemberNotFoundException;
import skku.nftlix_server.member.exception.NoLoginMemberException;
import skku.nftlix_server.member.exception.WrongPasswordException;
import skku.nftlix_server.member.repository.MemberRepository;


import static skku.nftlix_server.member.Member.createMember;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(SignUpRequest request) {

        if (memberRepository.existsByLoginId(request.loginId())) {
            throw new LoginIdAlreadyExistsException(request.loginId());
        }
        memberRepository.save(createMember(request.name(), request.loginId(), request.password()));
    }

    public LoginResponse login(LoginRequest request, HttpServletResponse response) {

        Member findMember = memberRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new MemberNotFoundException(request.loginId()));

        if (!findMember.getPassword().equals(request.password())) {
            throw new WrongPasswordException(request.loginId());
        }

        Cookie memberCookie = new Cookie("memberId", findMember.getId());
        response.addCookie(memberCookie);

        return new LoginResponse(findMember.getId());
    }

    public Member getLoginMember(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        // 쿠키가 없을 경우
        if (cookies == null) {
            throw new NoLoginMemberException();
        }

        // 원하는 쿠키 이름으로 탐색
        for (Cookie cookie : cookies) {
            if ("memberId".equals(cookie.getName())) {
                return memberRepository.findById(cookie.getValue())
                        .orElseThrow(() -> new MemberNotFoundException(cookie.getValue()));
            }
        }

        throw new NoLoginMemberException();
    }
}
