package com.target.assignment.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="productsprice")
public class ProductsPrice implements Serializable {
    private static final long serialVersionUID = -8331537878236316444L;

    @Id
    private String id;
    private Double price;
    private String currencyCode;


    public ProductsPrice() {
    }

    public ProductsPrice(String productId, Double price, String currencyCode) {
        this.id = productId;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    @JsonIgnore
    @JsonProperty(value = "productId")
    public String getProductId() {
        return id;
    }

    public void setProductId(String productId) {
        this.id = productId;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }


    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "ProductPrice {"
                + "price=" + price + ","
                + "currencyCode =" + currencyCode + "}";
    }

}