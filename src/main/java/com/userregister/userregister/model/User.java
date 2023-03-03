package com.userregister.userregister.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private char sex;
    private String dateOfBirth;
    private String email;

    public User(int id, String username, String password, char sex, String dateOfBirth, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
