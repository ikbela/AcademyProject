package com.example.demo.repositories;


import com.example.demo.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends CrudRepository<Sale,Long> {
}
