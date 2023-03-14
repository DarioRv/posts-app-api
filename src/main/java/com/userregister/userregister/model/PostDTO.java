package com.userregister.userregister.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDTO {
    private int id;
    private String title;
    private String body;
    private String image;
    private String date;
    private int idUserOwner;
    private List<CommentDTO> postComments;

    public PostDTO(int id, String title, String body, String image, String date, int idUserOwner, List<CommentDTO> postComments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.date = date;
        this.idUserOwner = idUserOwner;
        this.postComments = postComments;
    }

    public PostDTO() {
    }
    
}
