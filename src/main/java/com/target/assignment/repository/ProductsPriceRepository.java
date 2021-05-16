package com.target.assignment.repository;

import com.target.assignment.document.ProductsPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductsPriceRepository extends MongoRepository<ProductsPrice,Integer> {

    public Optional<ProductsPrice> findProductById(String id);

}
