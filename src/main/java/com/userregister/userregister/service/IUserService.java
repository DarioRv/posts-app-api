package com.userregister.userregister.service;

import com.userregister.userregister.model.User;
import java.util.List;

public interface IUserService {
    public void saveUser (User user);
    public void deleteUser (int id);
    public List<User> usersList ();
    public User login (String username, String password);
}
