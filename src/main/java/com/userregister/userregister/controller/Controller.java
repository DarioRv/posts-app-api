package com.userregister.userregister.controller;

import com.userregister.userregister.model.Post;
import com.userregister.userregister.model.User;
import com.userregister.userregister.model.UserLogin;
import com.userregister.userregister.service.IPostService;
import com.userregister.userregister.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    public IUserService userService;
    @Autowired IPostService postService; 
    
    @PostMapping ("/new/user")
    public void saveUser (@RequestBody User user) {
        userService.saveUser(user);
    }
    @PutMapping ("/update/user")
    public void updateUser (@RequestBody User user) {
        userService.saveUser(user);
    }
    @DeleteMapping ("/delete/user")
    public void deleteUser (@RequestParam int id) {
        userService.deleteUser(id);
    }
    @GetMapping ("/get/all-users")
    public List<User> getAllUsers () {
        System.out.println(userService.usersList());
        return userService.usersList();
    }
    @GetMapping ("/get/by-id-user")
    public User getUserById (@RequestParam int id) {
        return userService.findById(id);
    }
    @PostMapping ("/login")
    public User login(@RequestBody UserLogin user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
    @PostMapping ("/new/post")
    public void savePost (@RequestBody Post post) {
        postService.savePost(post);
    }
    @DeleteMapping ("/delete/post")
    public void deletePost (@RequestParam int id) {
        postService.deletePost(id);
    }
    @GetMapping ("/get/all-posts")
    public List<Post> getPosts () {
        return postService.getPosts();
    }
    @GetMapping ("/get/all-posts-by-owner")
    public List<Post> findByOwnerId (@RequestParam int id) {
        return postService.findByUserOwner(id);
    }
    
}
