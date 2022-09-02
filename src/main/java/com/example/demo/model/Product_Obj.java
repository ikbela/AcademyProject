package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

public class Product_Obj {
    @CsvBindByName
    private String emer;
    @CsvBindByName
    private String description;
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String price;

    public String getEmer() {
        return emer;
    }

    public void setEmer(String emer) {
        this.emer = emer;
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

    public Product_Obj() {
    }

    public Product_Obj(String name, String description, String date, String price) {
        this.emer = name;
        this.description = description;
        this.date = date;
        this.price = price;
    }
}
