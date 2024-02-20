package com.ll.react_spring.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yml"})
class JwtUtilTest {

    @Test
    @DisplayName("JWT 테스트")
    void jwtTest() {

//        Map<String , String > data = Map.of("name", "홍길동" , "age" , "22");
//
//        String jwtToken = JwtUtil.encode(data);
//
//        System.out.println("jwt token = " + jwtToken);
//
//
//        assertThat(jwtToken).isNotNull();

    }

}