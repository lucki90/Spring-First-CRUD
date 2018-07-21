package com.sda.spring.javaSpring1.service;

import com.sda.spring.javaSpring1.exception.NotFoundException;
import com.sda.spring.javaSpring1.model.Product;
import com.sda.spring.javaSpring1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product created(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void delete(Long id) {
        if(!productRepository.existsById(id)){
            throw new NotFoundException(String.format("Product with id=%s does not exist", id));
        }
        productRepository.deleteById(id);
    }
}
