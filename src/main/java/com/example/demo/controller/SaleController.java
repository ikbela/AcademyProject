package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class SaleController {
@Autowired
private SaleService saleService;
 @GetMapping("/SalesPage")

    public String salesHomePage(Model model){

        model.addAttribute("allSalesOfLastWeek",saleService.allLastWeekSales());
        model.addAttribute("total",saleService.totalPrice());

        return "SalesTableDisplay.jsp";
    }


}
