package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

 @Autowired
    ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }
    public Product findByName(String  s) {
        return productRepository.findByName(s);
    }

}
