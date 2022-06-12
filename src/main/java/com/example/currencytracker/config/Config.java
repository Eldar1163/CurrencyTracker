package com.example.currencytracker.config;

import com.example.currencytracker.exception.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ErrorDecoder getDecoder() {
        return new CustomErrorDecoder();
    }
}
