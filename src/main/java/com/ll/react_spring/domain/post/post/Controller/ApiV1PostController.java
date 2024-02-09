package com.ll.react_spring.domain.post.post.Controller;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Service.PostService;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ApiV1PostController {

    private final PostService postService;

    @PostMapping("/post")
    public Post create(@RequestBody PostDto postDto) {


        return postService.createPost(postDto);
    }

    @GetMapping("/post/list")

    public List<PostDto> list(){

        return  postService.getPostList();
    }
}
