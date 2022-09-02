package com.example.demo.service;


import com.example.demo.model.UploadedFile;
import com.example.demo.repositories.UploadsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadsService {
    @Autowired
    private UploadsRepo uploadsRepo;
    public void upload(String url) {
        UploadedFile uploadedFile= new UploadedFile(url);
       uploadsRepo.save(uploadedFile);
    }

    public List<UploadedFile> allFiles() {
        List<UploadedFile> files= uploadsRepo.findAll();
        return files;

    }
}