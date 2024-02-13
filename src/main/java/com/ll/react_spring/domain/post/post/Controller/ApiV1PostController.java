package com.ll.react_spring.domain.post.post.Controller;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Service.PostService;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ApiV1PostController {

    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Post> create(@Valid @RequestBody PostDto postDto) {


        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/post/list")
    public List<PostDto> list() {

        return postService.getPostList();
    }

    @GetMapping("post/detail/{id}")
    public PostDto detail(@PathVariable Long id){

        return this.postService.getPost(id);

    }

    @PutMapping("post/modify/{id}")
    public PostDto showModify(@PathVariable Long id , @RequestBody PostDto postDto) {

        return postService.modifyPost(postDto , id);
    }
    @DeleteMapping("post/delete/{id}")
    public void deletePost( @PathVariable Long id ) {

         postService.deletePost(id);
    }
}



