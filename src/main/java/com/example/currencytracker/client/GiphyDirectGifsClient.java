package com.example.currencytracker.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "giphyDirect", url = "${giphy.direct_gif_address}")
public interface GiphyDirectGifsClient {
    @GetMapping("/{id}/giphy.gif")
    Resource getGiffById(@PathVariable String id);
}
