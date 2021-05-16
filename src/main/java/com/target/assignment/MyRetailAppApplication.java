package com.target.assignment;

import com.target.assignment.feign.ProductServiceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = ProductServiceProxy.class)

public class MyRetailAppApplication {

	public static void main(String[] args) {
    	SpringApplication.run(MyRetailAppApplication.class, args);

	}

}
