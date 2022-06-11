package com.example.currencytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyTrackerApplication.class, args);
    }

}
