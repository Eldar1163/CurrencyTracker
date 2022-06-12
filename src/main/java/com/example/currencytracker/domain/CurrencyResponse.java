package com.example.currencytracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponse {
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;
}
