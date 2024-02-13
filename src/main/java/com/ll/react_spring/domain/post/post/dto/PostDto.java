package com.ll.react_spring.domain.post.post.dto;

import com.ll.react_spring.domain.post.post.Entity.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {

    private final Long id;
    @NotBlank
    private final String title;
    @NotBlank
    private final String content;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private final LocalDateTime createDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private final LocalDateTime modifyDate;

    //엔티티
    public Post toEntity()  {
        return Post.builder()
                .title(title)
                .content(content)
                .build();

    }



}
