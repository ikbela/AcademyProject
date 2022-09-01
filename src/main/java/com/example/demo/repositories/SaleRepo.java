package com.example.demo.repositories;

import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo {

    @Query(value = "SELECT s FROM Sale WHERE DAY(NOW())-7<=DAY(s.createdAt)<DAY(NOW())",nativeQuery = true)
    List<Sale> allSalesFromLastWeek();

}
