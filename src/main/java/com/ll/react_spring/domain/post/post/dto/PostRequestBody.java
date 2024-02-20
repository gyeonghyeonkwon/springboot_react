package com.ll.react_spring.domain.post.post.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request DTO
 */
@Getter
@Setter
public class PostRequestBody {

    private String title;
    private String content;
}
