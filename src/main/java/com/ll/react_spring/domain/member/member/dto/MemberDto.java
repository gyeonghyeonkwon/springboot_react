package com.ll.react_spring.domain.member.member.dto;

import com.ll.react_spring.domain.member.member.Entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private final Long id;

    private final String username;

    private final String nickname;

    private final LocalDateTime createDate;

    private final LocalDateTime modifyDate;

    // 엔티티 → DTO 변환
    public MemberDto(Member member) {

        this.id = member.getId();
        this.username= member.getUsername();
        this.nickname=member.getNickname();
        this.createDate = member.getCreateDate();
        this.modifyDate = member.getModifyDate();

    }

}
