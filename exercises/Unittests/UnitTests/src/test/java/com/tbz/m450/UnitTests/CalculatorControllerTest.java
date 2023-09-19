package com.tbz.m450.UnitTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/add")
                        .param("num1", "5")
                        .param("num2", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(is("8.0")));
    }

    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/subtract")
                        .param("num1", "10")
                        .param("num2", "4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(is("6.0")));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/multiply")
                        .param("num1", "6")
                        .param("num2", "7"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(is("42.0")));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/divide")
                        .param("num1", "20")
                        .param("num2", "5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(is("4.0")));
    }
}

