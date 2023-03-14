package com.userregister.userregister.repository;

import com.userregister.userregister.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer> {
    @Query(value = "SELECT c FROM Comment c WHERE c.post.id = ?1")
    public List<Comment> getCommentsByPostId (int id);
}
