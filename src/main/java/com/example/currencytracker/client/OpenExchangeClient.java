package com.example.currencytracker.client;

import com.example.currencytracker.domain.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openExchange", url = "${open-exchange.address}")
public interface OpenExchangeClient {
    @GetMapping("/latest.json")
    CurrencyResponse getLatestExchangeRates(@RequestParam(name = "app_id") String appId);

    //Date in format YYYY-MM-DD
    @GetMapping("/historical/{date}.json")
    CurrencyResponse getForAnyDayExchangeRates(@RequestParam(name = "app_id") String appId,
                                               @PathVariable(name = "date") String date);
}
