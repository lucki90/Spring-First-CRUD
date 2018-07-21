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

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getAll(){
//        return productService.getAll();
//    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable Long id,
                          @RequestBody Product product){
        return productService.update(id, product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> search(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "minPrice", defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice
            ){
        if (maxPrice == null){
        maxPrice = Double.MAX_VALUE;

        }
        return productService.search(name, minPrice, maxPrice);
    }

}
