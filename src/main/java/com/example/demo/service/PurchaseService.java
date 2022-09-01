package com.example.demo.service;

import com.example.demo.model.Purchase;
import com.example.demo.repositories.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepo pRepo;

    public List<Purchase> allPurchasesOfLastMonth(){
        return pRepo.allPurchasesFromLastMonth();
    }
}
