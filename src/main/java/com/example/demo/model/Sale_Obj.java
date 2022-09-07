package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

public class Sale_Obj {

    @CsvBindByName
    private String product;
    @CsvBindByName
    private String buyer;

    @CsvBindByName
    private String date;

    @CsvBindByName
    private String price;

    public Sale_Obj(String product, String buyer,String date, String price) {
        this.product = product;
        this.buyer = buyer;
        this.date = date;
        this.price = price;

    }

    public Sale_Obj() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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
