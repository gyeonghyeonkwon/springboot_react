package com.ll.react_spring.domain.post.post.Service;

import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Repository.PostRepository;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostDto postDto) {

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


    }



//        return posts.stream()
//                .map(post -> PostDto.builder()
//                        .id(post.getId())
//                        .title(post.getTitle())
//                        .content(post.getContent())
//                        .createDate(post.getCreateDate())
//                        .modifyDate(post.getModifyDate())
//                        .build())
//                .collect(Collectors.toList());