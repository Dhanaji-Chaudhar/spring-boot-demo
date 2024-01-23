package com.demos.controller;

import com.demos.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountService accountService;

    @Test
    void contextLoads(){
        Assertions.assertThat(accountController).isNotNull();
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetAccountDetails() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account/get/4"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAccountDetailsById() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account/get/4"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllAccounts() {
    }

    @Test
    void testGetAccountsByType() {
    }

    @Test
    void testCreateNewAccount() {
    }
}