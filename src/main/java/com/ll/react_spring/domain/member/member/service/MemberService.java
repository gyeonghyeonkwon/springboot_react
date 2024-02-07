package com.ll.react_spring.domain.member.member.service;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    public class MemberService {

        private final MemberRepository memberRepository;
        private final PasswordEncoder passwordEncoder;

        public Optional<Member> findByUsername(String username) {
            return memberRepository.findByUsername(username);
        }

        @Transactional
        public void join(String username, String password) {
            Member member = Member.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .build();

            memberRepository.save(member);
        }

        public boolean passwordMatches(Member member, String password) {
            return passwordEncoder.matches(password, member.getPassword());
        }
    }
