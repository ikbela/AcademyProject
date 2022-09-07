package com.example.demo.repositories;

import com.example.demo.model.UploadedFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UploadsRepo extends CrudRepository<UploadedFile, Long> {
 List<UploadedFile> findAll();
 List<UploadedFile> findByFileNameContaining(String s);
 UploadedFile findByUrl(String s);
}
