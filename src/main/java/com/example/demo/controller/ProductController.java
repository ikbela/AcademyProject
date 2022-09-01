package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String showProduct(Model model){
        Product product= new Product("produkti07","Ska cna bo ne polecia",5000);
        System.out.println(product.getPrice());
        productService.addProduct(product);
        List<Product> allProducts= productService.getAllProducts();
        model.addAttribute("allProducts",allProducts);
        return "productPage.jsp";

    }

}
