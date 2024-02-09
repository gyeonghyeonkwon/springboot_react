package com.ll.react_spring.global.initData;

import com.ll.react_spring.domain.member.member.service.MemberService;
import com.ll.react_spring.domain.post.post.Service.PostService;
import com.ll.react_spring.domain.post.post.dto.PostDto;
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
            memberService.join("admin", "1234");
            memberService.join("user1", "1234");
            memberService.join("user2", "1234");

            postService.createPost(PostDto.builder()
                            .title("하하")
                            .content("호호")
                    .build());
        };
    }
}

