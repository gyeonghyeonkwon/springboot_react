package com.ll.react_spring.domain.post.post.Service;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Repository.PostRepository;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName("게시글 찾기 ")
    void getPost() {
        Post post = Post.builder()
                .title("하하")
                .content("호호")
                .build();
        Post savePost = postRepository.save(post);

        PostDto findPostDto = postService.getPost(1L);

        assertThat(findPostDto.getId()).isEqualTo(1L);
    }
}