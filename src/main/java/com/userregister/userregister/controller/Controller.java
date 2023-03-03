package com.userregister.userregister.controller;

import com.userregister.userregister.model.User;
import com.userregister.userregister.service.UserService;
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
    public UserService userService; 
    
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
        return userService.usersList();
    }
}
