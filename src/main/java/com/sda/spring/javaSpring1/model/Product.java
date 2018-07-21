package com.sda.spring.javaSpring1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "receipt_id")
//    private Receipt receipt;

    public void updateFrom(Product product) {
        if (product.getName() != null) {
            this.name = product.getName();
        }
        if (product.getPrice() != null) {
            this.price = product.getPrice();
        }
    }
}
