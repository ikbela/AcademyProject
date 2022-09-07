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

    public void save(Sale sale) {
        saleRepo.save(sale);
    }

    public List<Sale> allLastWeekSales(){
        return  saleRepo.allSalesFromLastWeek();
//        return  saleRepo.findAll();
    }



    public String totalPrice(){
        Integer totally=0;
        for (Sale sl:allLastWeekSales()
             ) {
            totally+=sl.getPrice();
        }
        return totally.toString();
    }

}
