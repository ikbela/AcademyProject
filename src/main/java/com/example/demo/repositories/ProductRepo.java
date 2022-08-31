package com.example.demo.repositories;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
    List<Product> findAll();
    Product findByCreatedAt(Date date);
    @Query(value = "SELECT p FROM Product p WHERE p.price<=10000")
    List<Product> getPriceMinor();
    }
