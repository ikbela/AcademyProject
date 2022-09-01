package com.example.demo.repositories;

import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends CrudRepository<Sale,Long> {

    @Query(value = "SELECT s FROM sales WHERE DAY(NOW())-7<=DAY(s.createdAt)<DAY(NOW())",nativeQuery = true)
    List<Sale> allSalesFromLastWeek();

}
