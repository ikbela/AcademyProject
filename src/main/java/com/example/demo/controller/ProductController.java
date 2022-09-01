package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product")
    public String showProduct(Model model){
        List<Product> allProducts= productService.getAllProducts();
        model.addAttribute("allProducts",allProducts);
        return "productPage.jsp";

    }
    @GetMapping("/product/get-pdf")
    public String getMinor10000Pdf(Model model){
        List<Product> allProducts= productService.getAllProductMinor10000();
        getPdf(allProducts);
        model.addAttribute(productService.getAllProductMinor10000());
        return "productPage.jsp";

    }


    public void getPdf(List<Product> productToAdd)  {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Minor_1000_prod"+LocalDateTime.now()+".pdf"));
            document.open();
            PdfPTable table = new PdfPTable(4);
            addTableHeaderProduct(table);
            addRowsProduct(table,productToAdd);
            document.add(table);
            document.close();
        }catch (Exception e){


        }

    }
    private void addTableHeaderProduct(PdfPTable table) {
        Stream.of("Name", "Discription", "Date", "Price")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }
    private void addRowsProduct(PdfPTable table, List<Product> products) {
        for (Product product:products) {
            table.addCell(product.getName());
            table.addCell(product.getDescription());
            table.addCell( product.getCreatedAt().toString());
            table.addCell(product.getPrice().toString());
        }

    }


}
