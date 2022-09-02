package com.example.demo.model;

import javax.persistence.*;
import java.io.File;

@Table
@Entity(name = "uploaded")
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    private Long size;

    private String extention;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public UploadedFile() {
    }

    public UploadedFile(String url) {
        this.url = url;
    }


    public UploadedFile(String url, Long size, String extention) {
        this.url = url;
        this.size = size;
        this.extention= extention;
    }
}
