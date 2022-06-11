package com.example.currencytracker.client;

import com.example.currencytracker.domain.GifSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "giphy", url = "${giphy.address}")
public interface GiphyClient {
    @GetMapping("/search")
    GifSearchResponse searchGifByQuery(@RequestParam(name = "api_key") String apiKey,
                                        @RequestParam(name = "q") String query);
}
