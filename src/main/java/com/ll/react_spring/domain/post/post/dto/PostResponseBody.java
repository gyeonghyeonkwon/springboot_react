package com.ll.react_spring.domain.post.post.dto;

import com.ll.react_spring.domain.post.post.Entity.Post;
import lombok.Getter;

/**
 * Response DTO
 */
@Getter
public class PostResponseBody {

    private final PostDto item;

    public PostResponseBody(Post post) {
        item = new PostDto(post);
    }
}
