package com.userregister.userregister.service;

import com.userregister.userregister.model.Comment;
import com.userregister.userregister.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    @Autowired
    public CommentRepository commentRepository;
    
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        return commentRepository.getCommentsByPostId(id);
    }
    
}
