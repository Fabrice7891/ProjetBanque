package com.example.banquerests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.banquerests.entities"})
public class BanquerestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanquerestsApplication.class, args);
    }

}
