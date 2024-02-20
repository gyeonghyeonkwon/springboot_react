package com.ll.react_spring.domain.post.post.dto;

import com.ll.react_spring.domain.post.post.Entity.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {

    private final Long id;
    @NotBlank
    private final String title;
    @NotBlank
    private final String content;

    private final Long memberId;

    private final String memberName;

    private final LocalDateTime createDate;

    private final LocalDateTime modifyDate;



    public PostDto (Post post){

       this.id = post.getId();
       this.createDate= post.getCreateDate();
       this.modifyDate = post.getModifyDate();
       this.memberId = post.getMember().getId();
       this.memberName = post.getMember().getName();
       this.title = post.getTitle();
       this.content=post.getContent();
    }

}
