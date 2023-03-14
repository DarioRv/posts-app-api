package com.userregister.userregister.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentDTO {
    private int id;
    private String text;
    private int idPostFk;
    private int idUserFk;
    private String username;

    public CommentDTO(int id, String text, int idPostFk, int idUserFk, String username) {
        this.id = id;
        this.text = text;
        this.idPostFk = idPostFk;
        this.idUserFk = idUserFk;
        this.username = username;
    }
    
    public CommentDTO() {
    }
    
}
