package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message="Username must be greater than 3 characters")
    private String buyer;

   @PositiveOrZero
   private Integer price;


    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;


    @Column(updatable=false)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Sale(Long id, String buyer, Integer price, Date createdAt, Date date, Product product) {
        this.id = id;
        this.buyer = buyer;
        this.price = price;
        this.createdAt = createdAt;
        this.date = date;
        this.product = product;
    }

    public Sale(Long id, String buyer, Integer price, Date createdAt) {
        this.id = id;
        this.buyer = buyer;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Sale() {
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
