package com.ll.react_spring.domain.member.member.service;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.Repository.MemberRepository;
import com.ll.react_spring.global.config.SecurityUser;
import com.ll.react_spring.global.rsData.RsData;
import com.ll.react_spring.global.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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

        public Optional<Member> findById(Long id) {
            return memberRepository.findById(id);
        }

        @Transactional
        public RsData<Member> join(String username, String password , String nickname) {
            Member member = Member.builder()
                    .username(username)
                    .nickname(nickname)
                    .password(passwordEncoder.encode(password))
                    .build();
            memberRepository.save(member);

          return  RsData.of("200", "%s 님 가입을 환영합니다 ".formatted( username) , member);
        }

        public SecurityUser getUserFromApiKey (String apiKey) {

            Claims claims = JwtUtil.decode(apiKey);

            Map<String, Object> data = (Map<String, Object>) claims.get("data");

            long id = Long.parseLong((String) data.get("id"));
            String username = ((String) data.get("username"));

            List<? extends GrantedAuthority> authorities = ((List<String>) data.get("authorities"))
                    .stream()
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            return new SecurityUser( id , username ,  "" , authorities);
        }


        public RsData<Member> checkUsernameAndPassword(String username ,  String password) {

           Member member = memberRepository.findByUsername(username).orElseThrow(()

                   ->new IllegalArgumentException("아이디를 찾을수없습니다 "));

            if(!passwordEncoder.matches(password , member.getPassword())) {

                throw new IllegalArgumentException("비밀번호가 일치 하지 않습니다.");
            }

            return RsData.of("200" , "로그인 성공" , member);
        }
    }
