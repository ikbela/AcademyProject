package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(unique = true)
    @Size(min = 3)
    private String emer;

    @Size(min=3, max = 250, message=" Description must be 3 to 10 characters long")
    private String description;

    @Column(updatable=false)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date date;
    @Column(updatable=false)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

   @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    private Integer price;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;*/

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
//    private Purchase purchase;

    public Product() {

    }

    public Product(String name, String description, Date date, Integer price) {
        this.emer = name;
        this.description = description;
        this.date = date;
        this.price = price;
       /* this.sale = sale;
        this.purchase = purchase;*/
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

/*    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }*/
}
