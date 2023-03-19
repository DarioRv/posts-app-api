package com.userregister.userregister.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "text", nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn (name = "ID_POST_FK", nullable = false)
    private Post post;
    @ManyToOne
    @JoinColumn (name = "ID_USER_FK", nullable = false)
    private User user;

    public Comment(int id, String text, Post post, User user) {
        this.id = id;
        this.text = text;
        this.post = post;
        this.user = user;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @JsonBackReference(value="postComments")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @JsonBackReference(value="userComments")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
