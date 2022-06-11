package com.example.currencytracker.client;


import com.example.currencytracker.domain.GifObj;
import com.example.currencytracker.domain.GifSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GiphyClientWrapper {
    private final GiphyClient giphyClient;
    private final GiphyDirectGifsClient directGifsClient;

    @Value ("${giphy.api_key}")
    private String apiKey;

    public GiphyClientWrapper(GiphyClient giphyClient, GiphyDirectGifsClient directGifsClient) {
        this.giphyClient = giphyClient;
        this.directGifsClient = directGifsClient;
    }

    public GifSearchResponse searchGifByQuery(String query) {
        return giphyClient.searchGifByQuery(apiKey, query);
    }

    public GifObj getRandomGifByQuery(String query) {
        GifSearchResponse response = giphyClient.searchGifByQuery(apiKey, query);
        return response.getDataList().get(new Random().nextInt(response.getPagination().getCount()));
    }

    public ResponseEntity<Resource> getRandomDirectGiffByQuery(String query) {
        GifObj gifObj = getRandomGifByQuery(query);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(directGifsClient.getGiffById(gifObj.getId()));
    }
}
