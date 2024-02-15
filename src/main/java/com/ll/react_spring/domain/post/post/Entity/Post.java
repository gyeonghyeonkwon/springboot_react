package com.ll.react_spring.domain.post.post.Entity;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import com.ll.react_spring.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    private Member member;

    public PostDto toDto(Post post){

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .modifyDate(post.getModifyDate())
                .createDate(post.getCreateDate())
                .build();
    }
}
