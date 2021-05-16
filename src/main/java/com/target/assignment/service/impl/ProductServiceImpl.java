package com.target.assignment.service.impl;

import com.mongodb.MongoException;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.assignment.document.Products;
import com.target.assignment.document.ProductsPrice;
import com.target.assignment.feign.ProductServiceProxy;
import com.target.assignment.repository.ProductsPriceRepository;
import com.target.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service(value="ProductService")
public class ProductServiceImpl implements ProductService {

    private final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

    @Autowired
    private ProductServiceProxy serviceProxy;

    @Autowired
    private ProductsPriceRepository productRepository;

    @Override
    public Products getProductById(String productId) {
        ProductsPrice productPrice = productRepository.findProductById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Price Info not found in Mongo DB for ID :" + productId));
        Products product = new Products();
        product.setProductId(productId);
        product.setProductsPrice(productPrice);
        product.setName(getProductName(productId));
        return product;

    }

     private String getProductName(String productId)  {
        Map<String, Map> prodMap = getProductDetailsFromRESTCall(productId);

        Map<String,Map> productMap = prodMap.get("product");
        Map<String,Map> itemMap = productMap.get("item");
        Map<String,String> prodDescrMap = itemMap.get(("product_description"));

        return prodDescrMap.get("title");
    }

    private Map<String, Map> getProductDetailsFromRESTCall(String productId) {

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> response = serviceProxy.getProductInfoById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product Info not found in REST API for ID :" + productId));
        Map<String, Map> prodInfoFromREST = null;
        try {
            prodInfoFromREST = objectMapper.readValue(response.getBody(), Map.class);
        } catch (JsonProcessingException e) {
            log.error("Product Price info cant not be read");
        }

        return prodInfoFromREST;
    }

    @Override
    public Products updateProduct(String id, Products products) {

        ProductsPrice updatedProductsPrice=products.getProductsPrice();
        updatedProductsPrice.setProductId(id);
        if(productRepository.findProductById(updatedProductsPrice.getProductId())!=null){
            updatedProductsPrice=productRepository.save(products.getProductsPrice());
        }else{
            throw new MongoException("Price for product with id="+id+" not found in mongo db for collection 'productsprice'");
        }
        log.info("Price updated :" + updatedProductsPrice);
        products.setProductsPrice(updatedProductsPrice);
        return products;
    }
}
