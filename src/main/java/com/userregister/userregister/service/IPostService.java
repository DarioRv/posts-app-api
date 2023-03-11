package com.userregister.userregister.service;

import com.userregister.userregister.model.Post;
import java.util.List;

public interface IPostService {
    public void savePost(Post post);
    public void deletePost(int id);
    public List<Post> getPosts ();
    public List<Post> findByUserOwner (int id);
}
