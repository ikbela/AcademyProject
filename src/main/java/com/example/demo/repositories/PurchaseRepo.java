package com.example.demo.repositories;

import com.example.demo.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepo extends CrudRepository<Long, Purchase> {

    //List the purchases from last month
    @Query(value = "SELECT s FROM Sale WHERE DAY(NOW())-30<=DAY(s.createdAt)<DAY(NOW())",nativeQuery = true)
    List<Purchase> allPurchasesFromLastMonth();
}
