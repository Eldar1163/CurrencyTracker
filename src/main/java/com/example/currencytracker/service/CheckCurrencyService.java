package com.example.currencytracker.service;

import com.example.currencytracker.client.GiphyClientWrapper;
import com.example.currencytracker.client.OpenExchangeWrapper;
import com.example.currencytracker.domain.CurrencyResponse;
import com.example.currencytracker.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CheckCurrencyService {

    private final GiphyClientWrapper giphyClient;
    private final OpenExchangeWrapper openExchangeClient;

    @Value("${app.comparable-currency}")
    private String currencyName;

    public CheckCurrencyService(GiphyClientWrapper giphyClient,
                                OpenExchangeWrapper openExchangeClient) {
        this.giphyClient = giphyClient;
        this.openExchangeClient = openExchangeClient;
    }
    public ResponseEntity<Resource> getResultAsImage(String currencyCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate. now();
        LocalDate yesterday = today. minusDays(1);

        CurrencyResponse latestCurrency = openExchangeClient.getLatestExchangeRates();
        CurrencyResponse yesterdayCurrency = openExchangeClient.getForAnyDayExchangeRates(yesterday.format(formatter));

        if (currencyCode != null)
            currencyName = currencyCode;

        Double todayCurrencyValue = latestCurrency.getRates().get(currencyName);
        Double yesterdayCurrencyValue = yesterdayCurrency.getRates().get(currencyName);

        if (todayCurrencyValue == null || yesterdayCurrencyValue == null)
            throw new BadRequestException("Not valid currency code");

        if (todayCurrencyValue < yesterdayCurrencyValue)
            return giphyClient.getRandomDirectGiffByQuery("Rich");
        else if (todayCurrencyValue > yesterdayCurrencyValue)
            return giphyClient.getRandomDirectGiffByQuery("Broke");
        else
            return giphyClient.getRandomDirectGiffByQuery("No change");
    }
}
