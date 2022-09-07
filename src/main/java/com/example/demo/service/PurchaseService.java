package com.example.demo.service;
import com.example.demo.model.Purchase;
import com.example.demo.repositories.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepo pRepo;

    LocalDate dateBefore30Days = LocalDate.now().minusDays(3);
    public List<Purchase> allPurchasesOfLastMonth(){
   // return pRepo.findByCreatedAtGreaterThan(dateBefore30Days);
       return pRepo.allPurchasesFromLastMonth();
        //return pRepo.findAll();

    }
    //Function to find the total
    public String totalPrice(){
        Integer total = 0;
        for(Purchase purchase : allPurchasesOfLastMonth()){
            total += purchase.getPrice();
        }
        return total.toString();
    }

    public void save(Purchase purchase) {
        pRepo.save(purchase);
    }
}
