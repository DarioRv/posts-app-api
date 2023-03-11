package com.userregister.userregister.service;

import com.userregister.userregister.model.User;
import com.userregister.userregister.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    public UserRepository userRepository;
    
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> usersList() {
        return userRepository.findAll();
    }
    
    @Override
    public User login (String username, String password) {
        User currentUser = null;
        for (User user : usersList()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                currentUser = user;
            }
        }
        return currentUser;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
