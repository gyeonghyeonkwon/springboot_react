package com.ll.react_spring.domain.member.member.Entity;

import com.ll.react_spring.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;


}
