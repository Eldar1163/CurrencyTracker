package com.example.currencytracker.service;

import com.example.currencytracker.client.GiphyClientWrapper;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckCurrencyService {

    private final GiphyClientWrapper giphyClient;

    public CheckCurrencyService(GiphyClientWrapper giphyClient) {
        this.giphyClient = giphyClient;
    }
    public ResponseEntity<Resource> getResultAsImage(String currencyCode) {
        return giphyClient.getRandomDirectGiffByQuery("Rich");
    }
}
