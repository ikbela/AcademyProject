package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.PDFGeneratorService;
import com.example.demo.service.ProductService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    private final PDFGeneratorService pdfGeneratorService;

    public ProductController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/product")
    public String showProduct(Model model){
        List<Product> allProducts= productService.getAllProductMinor10000();
        model.addAttribute("allProducts",allProducts);
        return "productPage.jsp";

    }
    @GetMapping("/product/get-pdf")
    public String getMinor10000Pdf(Model model){
        try {
            List<Product> allProducts= productService.getAllProductMinor10000();

            model.addAttribute("StringArray",getPdf(allProducts));
            return "displayProductPdf.jsp";
        }
        catch (Exception e){return  null;}


    }


    public String getPdf(List<Product> productToAdd)  {
        try {
            Document document = new Document();
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();
            PdfPTable table = new PdfPTable(4);
            addTableHeaderProduct(table);
            addRowsProduct(table,productToAdd);
            document.add(table);
            document.close();
            String encodedString=Base64.getEncoder().encodeToString(baos.toByteArray());
            return encodedString;



        }catch (Exception e){

        return null;
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
