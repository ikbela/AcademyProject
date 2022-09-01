package com.example.demo.repositories;

import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends CrudRepository<Sale,Long> {

//    select id from tbname
//    where date between date_sub(now(),INTERVAL 1 WEEK) and now();

//    @Query(value = "SELECT s FROM sales WHERE s.createdAt between date_sub(now(),INTERVAL 1 WEEK) and now())",nativeQuery = true)
//    List<Sale> allSalesFromLastWeek();

    List<Sale> findAll();

}
