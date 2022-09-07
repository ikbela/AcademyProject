package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

public class Purchase_Obj {
    @CsvBindByName
    private String product;
    @CsvBindByName
    private String description;
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String price;

    public Purchase_Obj(String product, String description, String date, String price) {
        this.product = product;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public Purchase_Obj() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
