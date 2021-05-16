package com.target.assignment.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",url="https://redsky.target.com/v3/pdp/tcin/" )
public interface ProductServiceProxy {

    /**
     * @param productId
     * @return
     */
    @GetMapping(value = "/{productId}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate")
    public ResponseEntity<String> getProductInfoById(@PathVariable("productId") String productId);
}
