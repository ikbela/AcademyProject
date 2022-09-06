/*
package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.ProductService;
import com.example.demo.service.SaleService;
import com.example.demo.service.UploadsService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Controller
    public class Rader {

        @Autowired
        ProductService productService;
        @Autowired
        UploadsService uploadsService;

        @Autowired
    SaleService saleService;

        @Autowired
        PurchaseSer
        private static String uploaded = "src/main/";


        @RequestMapping("/save/{id}")
        public String uploadCSVFile(@PathVariable("id") Long id) {

            UploadedFile file = uploadsService.findById(id);
                if(uploadsService.findByFileNameContaining(file, "product").booleanValue()==true) {
            // parse CSV file to create a list of `User` objects)
         try (Reader reader = new BufferedReader(new FileReader(uploaded + file.getUrl()))) {

                // create csv bean reader
                CsvToBean<Product_Obj> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Product_Obj.class)
                        .withIgnoreLeadingWhiteSpace(false)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Product_Obj> products = csvToBean.parse();

                // TODO: save users in DB?
                for (Product_Obj product_obj : products) {
                    Product p = new Product();

                    p.setName(product_obj.getName());
                    p.setDescription(product_obj.getDescription());
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    p.setDate(formatter.parse(product_obj.getDate()));
                    p.setPrice(Integer.valueOf(product_obj.getPrice()));
                    productService.save(p);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
                    return "redirect:/showFiles";}

           else-if(uploadsService.findByFileNameContaining(file, "sale").booleanValue()==true) {
                // parse CSV file to create a list of `User` objects)
                try (Reader reader = new BufferedReader(new FileReader(uploaded + file.getUrl()))) {

                    // create csv bean reader
                    CsvToBean<Sale_Obj> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Sale_Obj.class)
                            .withIgnoreLeadingWhiteSpace(false)
                            .build();

                    // convert `CsvToBean` object to list of users
                    List<Sale_Obj> sales = csvToBean.parse();

                    // TODO: save users in DB?
                    for (Sale_Obj sale_obj : sales) {
                        Sale s = new Sale();

                        s.setProduct(sale_obj.getProduct());
                        s.setBuyer(sale_obj.getBuyer());
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        s.setDate(formatter.parse(sale_obj.getDate()));
                        s.setPrice(Integer.valueOf(sale_obj.getPrice()));
                        saleService.save(s);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return "redirect:/showFiles";}



           else-if(uploadsService.findByFileNameContaining(file, "purchase").booleanValue()==true) {
                // parse CSV file to create a list of `User` objects)
                try (Reader reader = new BufferedReader(new FileReader(uploaded + file.getUrl()))) {

                    // create csv bean reader
                    CsvToBean<Purchase_Obj> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Purchase_Obj.class)
                            .withIgnoreLeadingWhiteSpace(false)
                            .build();

                    // convert `CsvToBean` object to list of users
                    List<Purchase_Obj> purchase = csvToBean.parse();

                    // TODO: save users in DB?
                    for (Product_Obj product_obj : products) {
                        Product p = new Product();

                        p.setName(product_obj.getName());
                        p.setDescription(product_obj.getDescription());
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        p.setDate(formatter.parse(product_obj.getDate()));
                        p.setPrice(Integer.valueOf(product_obj.getPrice()));
                        productService.save(p);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return "redirect:/showFiles";}






            else {
            return "redirect:/showFiles";
        }
        }

    public Long getFileSIze(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        // size of a file (in bytes)
        long bytes = Files.size(path);

        return bytes; }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public String getFileName(File f){
        return f.getName();
    }
    }
*/
