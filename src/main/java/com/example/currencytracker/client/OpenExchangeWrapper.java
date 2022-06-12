package com.example.currencytracker.client;

import com.example.currencytracker.domain.CurrencyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenExchangeWrapper {
    private final OpenExchangeClient openExchangeClient;

    @Value("${open-exchange.appid}")
    private String appId;

    public OpenExchangeWrapper(OpenExchangeClient openExchangeClient) {
        this.openExchangeClient = openExchangeClient;
    }

    public CurrencyResponse getLatestExchangeRates() {
        return openExchangeClient.getLatestExchangeRates(appId);
    }

    //Date in format YYYY-MM-DD
    public CurrencyResponse getForAnyDayExchangeRates(String date) {
        return openExchangeClient.getForAnyDayExchangeRates(appId, date);
    }
}
