package com.ll.react_spring.domain.post.post.Service;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Repository.PostRepository;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yml"})
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

    @Test
    @DisplayName("수정 테스트")
    void modifyPost(){
        Post post = Post.builder()

                .title("하하")
                .content("호호")
                .build();
         postRepository.save(post);

        //수정 부분

        PostDto postDto2 = PostDto.builder()
                .id(post.getId())
                .title("안녕")
                .content("하세요")
                .build();


        PostDto modifiedPostDto = postService.modifyPost(postDto2 , postDto2.getId());



//        assertThat(postDto.getTitle()).isNotEqualTo(modifypostDto.getTitle());
        assertThat(modifiedPostDto.getTitle()).isEqualTo("안녕");
        assertThat(modifiedPostDto.getId()).isEqualTo(post.getId());
        assertThat(modifiedPostDto.getTitle()).isNotEqualTo(post.getTitle());
    }

    @Test
    @DisplayName("삭제 테스트 ")
    void delete() {

        Post post = Post.builder()

                .title("하하")
                .content("호호")
                .build();
        postRepository.save(post);

        postService.deletePost(1L); //샘플데이터 도 삭제
        postService.deletePost(2L);
        assertEquals(0 , postRepository.count());
    }
}