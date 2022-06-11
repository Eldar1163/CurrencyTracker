package com.example.currencytracker.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "giphy")
public class GiphyProperties {
    private String apiKey;
    private String address;
    private String directGifAddress;
}
