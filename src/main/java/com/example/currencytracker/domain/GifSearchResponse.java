package com.example.currencytracker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GifSearchResponse {
    @JsonProperty(value = "data")
    private List<GifObj> dataList;
    private MetaObj meta;
    private Pagination pagination;
}
