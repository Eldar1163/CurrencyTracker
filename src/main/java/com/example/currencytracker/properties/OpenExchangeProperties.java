package com.example.currencytracker.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "open-exchange")
public class OpenExchangeProperties {
    private String address;
    private String addId;
}
