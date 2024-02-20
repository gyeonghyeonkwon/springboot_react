package com.ll.react_spring.domain.member.member.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestBody {


    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
