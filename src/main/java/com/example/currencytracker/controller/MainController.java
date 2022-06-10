package com.example.currencytracker.controller;

import com.example.currencytracker.exception.EmptyStringException;
import com.example.currencytracker.service.CheckCurrencyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    public Byte[] checkCurrency(
            @RequestParam(name = "currency_code")
            @Valid @NotBlank(message = "Currency code must not be empty")
            @Size(min = 3, max = 3, message = "Give a correct currency code")
                String currencyCode) {
        if (currencyCode.replaceAll("[^A-Z]", "").isEmpty())
            throw new EmptyStringException("Give a correct currency code");

        return currencyService.getResultAsImage(currencyCode);
    }
}
