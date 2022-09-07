package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

public class Product_Obj {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String description;
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.name = name;
        this.description = description;
        this.date = date;
        this.price = price;
    }
}
