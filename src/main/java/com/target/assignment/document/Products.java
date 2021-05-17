package com.target.assignment.document;

public class Products {
    private String productId;
    private String name;
    private ProductsPrice productPrice;

    public Products(String productId, String name, ProductsPrice productPrice) {
        this.productId = productId;
        this.name = name;
        this.productPrice =productPrice;
    }
    public Products() { }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductsPrice getProductsPrice() {
        return productPrice;
    }

    public void setProductsPrice(ProductsPrice productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productsPrice=" + productPrice +
                '}';
    }
}
