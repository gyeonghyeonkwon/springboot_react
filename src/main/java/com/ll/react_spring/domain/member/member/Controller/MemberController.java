package com.ll.react_spring.domain.member.member.Controller;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.form.LoginForm;
import com.ll.react_spring.domain.member.member.form.LoginResponseBody;
import com.ll.react_spring.domain.member.member.service.MemberService;
import com.ll.react_spring.global.Exception.GlobalException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/login")
    public LoginResponseBody login(@Valid @RequestBody LoginForm form) {

        Member member = memberService.findByUsername(form.getUsername())
                .orElseThrow(() -> new GlobalException("400-1", "해당 유저가 존재하지 않습니다."));

        if (memberService.passwordMatches(member, form.getPassword()) == false) {
            throw new GlobalException("400-2", "비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponseBody(member.getUsername());
    }
}