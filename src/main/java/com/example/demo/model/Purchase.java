package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
