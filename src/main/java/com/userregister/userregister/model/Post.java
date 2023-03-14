package com.userregister.userregister.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "BODY")
    private String body;
    @Column(name = "IMAGE")
    private String image;
    @Column(name = "DATE")
    private String date;
    @ManyToOne
    @JoinColumn(name = "ID_USER_FK")
    private User userOwner;
    @OneToMany(mappedBy = "post")
    private List<Comment> postComments;

    public Post(int id, String title, String body, String image, String date, User userOwner, List<Comment> postComments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.date = date;
        this.userOwner = userOwner;
        this.postComments = postComments;
    }
    
    public Post() {
    }

    @JsonManagedReference(value="postComments")
    public List<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<Comment> postComments) {
        this.postComments = postComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @JsonBackReference(value="userPosts")
    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }
    
    
}
