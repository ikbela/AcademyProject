package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Size(min = 3, message = "Description must be greater than 3 characters")
    private String description;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @PositiveOrZero
    private Integer price;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;


    public Purchase(Product product, String description, Date date, Integer price) {
        this.product = product;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public Purchase() {
    }

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

