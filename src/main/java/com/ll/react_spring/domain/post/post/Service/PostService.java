package com.ll.react_spring.domain.post.post.Service;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Repository.PostRepository;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import com.ll.react_spring.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@ToString
@Slf4j
public class PostService {

    private final PostRepository postRepository;



    @Transactional
    public RsData<Post> createPost(Member member , String title , String content) {

        Post post = Post.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();

        postRepository.save(post);

       return RsData.of("200" , "글작성 성공 ", post);
    }

    public List<Post> getPostList() {

        return postRepository.findAll();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public PostDto modifyPost( PostDto postDto ,  Long id ) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("글을 찾 을 수 없습니다 " + id));


        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post savePost = this.postRepository.save(post);


        return postDto; //엔티티 → DTO
    }

    @Transactional
    public void deletePost(Long id) {

        postRepository.deleteById(id);

    }
}



