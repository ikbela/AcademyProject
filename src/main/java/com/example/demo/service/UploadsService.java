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
    public UploadedFile upload(String url) {
        UploadedFile uploadedFile= new UploadedFile(url);
       return uploadsRepo.save(uploadedFile);
    }

    public void save(UploadedFile file) {
        uploadsRepo.save(file);
    }

    public UploadedFile findById(Long id) {
        return uploadsRepo.findById(id).orElse(null);
    }

    public List<UploadedFile> allFiles() {
        List<UploadedFile> files= uploadsRepo.findAll();
        return files;

    }

    public Boolean findByFileNameContaining(UploadedFile file, String s) {
       List<UploadedFile> files =uploadsRepo.findByFileNameContaining(s);
       return files.contains(file);

    }
}
