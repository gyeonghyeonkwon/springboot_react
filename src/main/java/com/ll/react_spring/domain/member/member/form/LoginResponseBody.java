package com.ll.react_spring.domain.member.member.form;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.dto.MemberDto;
import lombok.Getter;

@Getter
public class LoginResponseBody {

    private final MemberDto item;

    private final String accessToken;

    public LoginResponseBody(Member member , String accessToken) {
        this.item = new MemberDto(member);
        this.accessToken=accessToken;
    }
}
