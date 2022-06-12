package com.example.currencytracker.controller;

import com.example.currencytracker.service.CheckCurrencyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class MainController {
    public final CheckCurrencyService currencyService;

    public MainController(CheckCurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/check")
    public ResponseEntity<Resource> checkCurrency() {
        return currencyService.getResultAsImage();
    }
}
