package com.example.demo.repositories;


import com.example.demo.model.Sale;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends CrudRepository<Sale,Long> {

    @Query(value = "SELECT * FROM sales WHERE WEEK(created_at,0)= WEEK(NOW(),0)-1",nativeQuery = true)
            //(s.createdAt, 0) = WEEK(NOW(), 0) - 1")
    List<Sale> allSalesFromLastWeek();
    List<Sale> findAll();

}
