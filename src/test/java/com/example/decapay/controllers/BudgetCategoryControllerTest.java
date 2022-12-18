package com.example.decapay.controllers;

import com.example.decapay.configurations.security.CustomUserDetailService;
import com.example.decapay.configurations.security.JwtAuthFilter;
import com.example.decapay.services.BudgetCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers= BudgetCategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
class BudgetCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private CustomUserDetailService customUserDetailService;

    @MockBean
    private BudgetCategoryService budgetCategoryService;

    @MockBean
    private JwtAuthFilter jwtAuthFilter;


    @Test
    void testDeleteBudgetCategory() throws Exception {

        long budgetCategoryId = 1L;

        mockMvc.perform(delete("/api/v1/budgets/categories/{budgetCategoryId}", budgetCategoryId))
                .andExpect(status().isOk());
    }
}