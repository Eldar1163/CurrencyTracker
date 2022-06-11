package com.example.currencytracker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GifObj {
    private String id;
    @JsonProperty("embed_url")
    private String embedUrl;
}
