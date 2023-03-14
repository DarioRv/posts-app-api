package com.userregister.userregister.service;

import com.userregister.userregister.model.Comment;
import java.util.List;

public interface ICommentService {
    public void saveComment(Comment comment);
    public void deleteComment(int id);
    public List<Comment> getComments ();
    public List<Comment> getCommentsByPostId (int id);
}
