package com.target.assignment.config;

import com.target.assignment.document.ProductsPrice;
import com.target.assignment.repository.ProductsPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackageClasses = ProductsPriceRepository.class)
public class MongoDBConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductsPriceRepository productsPriceReposiotry){
        List<ProductsPrice> list = new ArrayList<>();
        list.add(new ProductsPrice("13860428", 20.90, "USD"));
        list.add(new ProductsPrice("54456119", 87.90, "USD"));
        list.add(new ProductsPrice("12954218", 80.20, "USD"));
        return string->productsPriceReposiotry.saveAll(list);

 }

}
