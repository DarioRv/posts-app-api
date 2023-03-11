package com.userregister.userregister.service;

import com.userregister.userregister.model.Post;
import com.userregister.userregister.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    public PostRepository postRepository;
    
    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findByUserOwner(int id) {
        return postRepository.findByUserOwner(id);
    }
    
}
