package com.ll.react_spring.domain.member.member.Controller;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.form.LoginRequestBody;
import com.ll.react_spring.domain.member.member.form.LoginResponseBody;
import com.ll.react_spring.domain.member.member.service.MemberService;
import com.ll.react_spring.global.rsData.RsData;
import com.ll.react_spring.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {
    private final MemberService memberService;

    /**
     * 로그인
     */
    @PostMapping("/login")
    public RsData<LoginResponseBody> login( @RequestBody LoginRequestBody requestBody) {

        RsData<Member> checkRs = memberService.checkUsernameAndPassword(requestBody.getUsername(), requestBody.getPassword());

        Member member = checkRs.getData(); // 아이디와 패스워드를 불러온다

        Long id = member.getId(); //멤버 아이디

        String accessToken = JwtUtil.encode(
                Map.of(
                        "id", id.toString(),
                        "authorities", member.getAuthoritiesAsStrList()
                )
        );
        return RsData.of("200" , " 로그인 성공" , new LoginResponseBody(member , accessToken));

    }
}