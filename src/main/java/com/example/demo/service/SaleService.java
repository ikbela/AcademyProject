package com.example.demo.service;

import com.example.demo.model.Sale;
import com.example.demo.repositories.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepo saleRepo;


    public List<Sale> allLastWeekSales(){
//        return  saleRepo.allSalesFromLastWeek();
        return  saleRepo.findAll();
    }

}
