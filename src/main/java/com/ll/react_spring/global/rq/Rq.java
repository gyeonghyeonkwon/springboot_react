package com.ll.react_spring.global.rq;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final MemberService memberService;
    private final EntityManager entityManager;
    private Member member;

    /**
     *
     * 스프링 시큐리티에서 로그인 한 아이디를 얻는다
     */
    public Member getMember() {
        if (member == null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            long memberId = Long.parseLong(user.getUsername());

            member = entityManager.getReference(Member.class , memberId);
            //Member member = new Member(memberId); 와 같다
        }

        return member;
    }

    public String getHeader(String name) {
        return request.getHeader(name);
    }
}
