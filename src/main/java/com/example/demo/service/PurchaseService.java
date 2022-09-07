package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Purchase;
import com.example.demo.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
