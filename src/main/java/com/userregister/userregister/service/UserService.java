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
    
}
