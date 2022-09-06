package com.example.demo.controller;

import com.example.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchase")
    public String purchase(Model model){
        model.addAttribute("lastWeekPurchases", purchaseService.allPurchasesOfLastMonth());
     //   model.addAttribute("lastWeekPurchases", purchaseService.allPurchases());

        //TOTAL PRICE
        model.addAttribute("totalPrice", purchaseService.totalPrice());
        return "purchase.jsp";
    }


}
