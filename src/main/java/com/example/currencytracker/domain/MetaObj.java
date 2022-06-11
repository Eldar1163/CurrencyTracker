package com.example.currencytracker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaObj {
    private String msg;
    private Integer status;
    @JsonProperty(value = "response_id")
    private String responseId;
}
