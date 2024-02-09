package com.ll.react_spring.domain.post.post.dto;

import com.ll.react_spring.domain.post.post.Entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {

    private final Long id;

    private final String title;

    private final String content;

    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;


    public Post toEntity()  {
        return Post.builder()
                .title(title)
                .content(content)
                .build();

    }
}
