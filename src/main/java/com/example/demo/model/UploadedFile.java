package com.example.demo.model;

import javax.persistence.*;

@Table
@Entity(name = "uploaded")
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UploadedFile() {
    }

    public UploadedFile(String url) {
        this.url = url;
    }


}
