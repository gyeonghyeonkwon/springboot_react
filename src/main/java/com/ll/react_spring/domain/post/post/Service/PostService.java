package com.ll.react_spring.domain.post.post.Service;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Repository.PostRepository;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@ToString
public class PostService {

    private final PostRepository postRepository;



    @Transactional
    public Post createPost(final PostDto postDto) {

       return postRepository.save(postDto.toEntity());
    }

    public List<PostDto> getPostList() {

        return postRepository.findAll().stream()
                .map(post -> PostDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .createDate(post.getCreateDate())
                        .modifyDate(post.getModifyDate())
                        .build())
                .collect(Collectors.toList());
    }

    public PostDto getPost(final Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("글을 찾 을 수 없습니다."));

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createDate(post.getCreateDate())
                .modifyDate(post.getModifyDate())
                .build();

    }

    @Transactional
    public PostDto modifyPost( PostDto postDto ,  Long id ) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("글을 찾 을 수 없습니다 " + id));


        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post savePost = this.postRepository.save(post);

        return post.toDto(savePost); //엔티티 → DTO
    }

    @Transactional
    public void deletePost(Long id) {

        postRepository.deleteById(id);

    }
}



