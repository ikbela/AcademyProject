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

}
