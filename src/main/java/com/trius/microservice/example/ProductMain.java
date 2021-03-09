package com.trius.microservice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductMain {

    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }
}
