package com.example.currencytracker.integration;

import com.example.currencytracker.controller.MainController;
import com.example.currencytracker.service.CheckCurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
class CurrencyTrackerApplicationTests {
    private final String apiPath = "http://localhost:8080/api/check";

    @MockBean
    private CheckCurrencyService currencyService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MainController controller;

    @Test
    void checkBeans() {
        assertThat(controller).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void incorrectCurrencyCode() throws Exception {
        mockMvc.perform(get(apiPath).param("currency_code", "abc"))
                .andDo(print())
                .andExpect(status().isBadRequest());
        mockMvc.perform(get(apiPath).param("currency_code", "e"))
                .andDo(print())
                .andExpect(status().isBadRequest());
        mockMvc.perform(get(apiPath).param("currency_code", ""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void correctCurrencyCode() throws Exception {
        mockMvc.perform(get(apiPath).param("currency_code", "RUB"))
                .andExpect(status().isOk());
    }
}
