package com.ll.react_spring.domain.post.post.Repository;

import com.ll.react_spring.domain.post.post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

    List<Post> findAll();
}
