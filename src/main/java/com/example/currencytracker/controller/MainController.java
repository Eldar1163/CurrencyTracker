package com.example.currencytracker.controller;

import com.example.currencytracker.exception.BadRequestException;
import com.example.currencytracker.service.CheckCurrencyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Validated
public class MainController {
    public final CheckCurrencyService currencyService;

    public MainController(CheckCurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/check")
    public ResponseEntity<Resource> checkCurrency(
            @RequestParam(name = "currency_code")
            @Valid
            @Size(min=3, max = 3, message = "Enter correct currency code")
            @NotEmpty(message = "currency_code must not be empty") String currencyCode) {
        if (currencyCode.replaceAll("[^A-Z]", "").isEmpty())
            throw new BadRequestException("Enter correct currency code");
        return currencyService.getResultAsImage(currencyCode);
    }

    @GetMapping("check/default")
    public ResponseEntity<Resource> checkCurrency() {
        return currencyService.getResultAsImage(null);
    }
}
