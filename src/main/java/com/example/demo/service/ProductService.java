package com.example.demo.service;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getAllProducts(){return productRepo.findAll();}
    public List<Product> getAllProductMinor10000(){
        return productRepo.getPriceMinor();
    }
    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

    public void save(Product product) {
        productRepo.save(product);
    }
    public Product findByName(String  s) {
        return productRepo.findByName(s);
    }

}
