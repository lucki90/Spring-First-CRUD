package com.sda.spring.javaSpring1.repository;

import com.sda.spring.javaSpring1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> findByName(String nazwa);
//    List<Product> findByNameContaining(String nazwa);
//    List<Product> findByNameContaininIgnoreCase(String nazwa);
//    List<Product> findByNameContainingAndPriceGreaterThanEqual(
//            String nazwa, Double minPrice);

    //nazwy zawarte w nazwie metody maja odpowiadac tym co jest w polach produktu
    List<Product> findByNameContainingAndPriceGreaterThanEqualAndPriceLessThanEqual(
            String nazwa, Double minPrice, Double maxPrice);

    //mozna dodac OrderedByPriceDes - wtedy posortuje po cenie malejąco

}
