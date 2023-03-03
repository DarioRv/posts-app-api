package com.userregister.userregister.model;

import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {
    private String username;
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLogin() {
    }
}
