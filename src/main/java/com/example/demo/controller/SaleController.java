package com.example.demo.controller;

import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {
@Autowired
private SaleService saleService;
    @GetMapping("/")

    public String salesHomePage(Model model){

        model.addAttribute("allSalesOfLastWeek",saleService.allLastWeekSales());

        return "index.jsp";
    }
}
