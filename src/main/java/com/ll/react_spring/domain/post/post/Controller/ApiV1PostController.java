package com.ll.react_spring.domain.post.post.Controller;

import com.ll.react_spring.domain.member.member.Entity.Member;
import com.ll.react_spring.domain.member.member.service.MemberService;
import com.ll.react_spring.domain.post.post.Entity.Post;
import com.ll.react_spring.domain.post.post.Service.PostService;
import com.ll.react_spring.domain.post.post.dto.PostDto;
import com.ll.react_spring.domain.post.post.dto.PostRequestBody;
import com.ll.react_spring.domain.post.post.dto.PostResponseBody;
import com.ll.react_spring.global.rq.Rq;
import com.ll.react_spring.global.rsData.RsData;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ApiV1PostController {

    private final PostService postService;
    private final Rq rq;
    private final MemberService memberService;


    @Getter
    public static class GetPostsResponseBody {
        private final List<PostDto> items;
        private final Map pagination;

        public GetPostsResponseBody(List<Post> posts) {
            items = posts
                    .stream()
                    .map(PostDto::new)
                    .toList();

            pagination = Map.of("page", 1);
        }
    }



    @PreAuthorize("isAuthenticated()")
    @PostMapping("/post")

    public RsData<PostResponseBody> create(@Valid @RequestBody PostRequestBody postRequestBody ) {

        Member member =  rq.getMember();


        RsData<Post> postRsData = postService.createPost(member , postRequestBody.getTitle() , postRequestBody.getContent());

        return postRsData.of(new PostResponseBody(postRsData.getData()));
    }

    @GetMapping("/post/list")
    public  RsData<GetPostsResponseBody> list() {

        return RsData.of("200" , "성공" , new GetPostsResponseBody(postService.getPostList()));


    }

    @Getter
    public static class GetPostResponseBody {
        private final PostDto item;

        public GetPostResponseBody(Post post) {
            item = new PostDto(post);
        }
    }

    @GetMapping("post/detail/{id}")
    public RsData<GetPostResponseBody>  detail(@PathVariable Long id){

        return RsData.of("200" , "성공" , new GetPostResponseBody(postService.findById(id).get()));

    }
//    @GetMapping("post/modify/{id}")
//    public PostDto showModify (@PathVariable Long id ) {
//
//        return postService.findById(id);
//    }

    @PutMapping("post/modify/{id}")
    public PostDto putModify(@PathVariable Long id , @RequestBody PostDto postDto) {

        return postService.modifyPost(postDto , id);
    }
    @DeleteMapping("post/delete/{id}")
    public void deletePost( @PathVariable Long id ) {

         postService.deletePost(id); //삭제
    }
}



