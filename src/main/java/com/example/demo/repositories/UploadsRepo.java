package com.example.demo.repositories;

import com.example.demo.model.UploadedFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadsRepo extends CrudRepository<UploadedFile, Long> {

}
