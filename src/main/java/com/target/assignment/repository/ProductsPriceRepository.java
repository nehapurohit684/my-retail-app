package com.target.assignment.repository;

import com.target.assignment.document.ProductsPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsPriceRepository extends MongoRepository<ProductsPrice,Integer> {

    public ProductsPrice findProductById(String id);
}
