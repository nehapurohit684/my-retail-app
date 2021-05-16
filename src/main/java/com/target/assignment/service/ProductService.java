package com.target.assignment.service;

import com.target.assignment.document.Products;

public interface ProductService {

    public Products getProductById(String productId);

    public Products updateProduct(String id, Products products);
}
