package com.userregister.userregister.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="REPORT")
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    @Column(name="TYPE", nullable = false)
    private String type;
    @Column(name="COMMENT", nullable = false)
    private String comment;

    public Report(int id, String type, String comment) {
        this.id = id;
        this.type = type;
        this.comment = comment;
    }

    public Report() {
    }
    
}
