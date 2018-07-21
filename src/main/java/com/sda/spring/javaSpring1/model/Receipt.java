package com.sda.spring.javaSpring1.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "receipts")
@Data
public class Receipt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "client")
    private String client;

    @Column(nullable = false, name = "date")
    private LocalDateTime date;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

//    @OneToMany(mappedBy = "receipt")
//    private List<Product> products;

    // ManyToMany zamiast OneToMany i ManyToOne w Product
    @ManyToMany
    @JoinTable(
            name = "receipt_products",
            joinColumns = @JoinColumn(name = "receipt_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "product_id", nullable = false))
    private List<Product> products;
}