package com.example.demo.repositories;

import com.example.demo.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseRepo extends CrudRepository<Purchase,Long> {

    //List the purchases from last month
   @Query(value= "SELECT * FROM purchases WHERE MONTH(NOW())-2 < MONTH(created_at) and MONTH(created_at)<= MONTH(NOW())-1 ",nativeQuery = true)
    List<Purchase> allPurchasesFromLastMonth();



}
