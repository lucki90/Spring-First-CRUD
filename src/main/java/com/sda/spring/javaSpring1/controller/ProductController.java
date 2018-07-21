package com.sda.spring.javaSpring1.controller;

import com.sda.spring.javaSpring1.model.Product;
import com.sda.spring.javaSpring1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create (@RequestBody Product product){
        return productService.created(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll(){
        return productService.getAll();
    }
}
