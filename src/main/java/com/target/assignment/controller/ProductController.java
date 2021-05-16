package com.target.assignment.controller;

import com.mongodb.MongoException;
import com.target.assignment.document.Products;
import com.target.assignment.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@RestController
public class ProductController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @GetMapping(value="products/{id}")
    public Products getProducts(@PathVariable String id) throws HttpClientErrorException, MongoException, IOException {
        logger.info("getting Product Info for ID: "+id);
        Products products;
        products=productService.getProductById(id);
        logger.info("Product Info :"+products);
        return products;
    }

    @PutMapping(value="products/{id}")
    public Products putProductDetails(@PathVariable String id,@RequestBody Products prodDetails) throws Exception{
        Products updatedProd=productService.updateProduct(id, prodDetails);
        return updatedProd;
    }
}
