package com.ll.react_spring.global.initData;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.service.MemberService;
import com.ll.react_spring.domain.post.post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NotProd {

    private final MemberService memberService;
    private final PostService postService;

    @Bean
    ApplicationRunner initNotProd() {
        return args -> {
            Member member1 = memberService.join("admin", "1234" , "adminNick").getData();
            Member member2 = memberService.join("user1", "1234" , "userNick1").getData();
            Member member3 = memberService.join("user2", "1234","userNick2").getData();

            postService.createPost(member1 , "하하" , " 호호");
            postService.createPost(member2 , "하하2" , " 호호2");
            postService.createPost(member3 , "하하3" , " 호호3");
        };
    }
}

