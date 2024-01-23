package com.demos.controller;

import com.demos.pojo.Account;
import com.demos.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerByMockitoTest {
@Mock
private AccountService accountService;

@InjectMocks
private AccountController accountController;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetAccountDetailsById() {
        Account account= new Account();
        account.setAccountId(5);
        account.setAccountName("Dhanaji");
        account.setAccountType("Savings");
        account.setStatus("Active");
        ResponseEntity<Account> responseEntity= ResponseEntity.status(HttpStatus.OK).body(account);
        when(accountService.getAccountDetails(anyInt())).thenReturn(responseEntity.getBody());
        ResponseEntity<Account> response = accountController.getAccountDetails(4);
        Assertions.assertThat(response.getBody()).isNotNull();
        assertEquals(response.getBody().getAccountId(),5);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccountsByType() {
    }

    @Test
    void createNewAccount() {
    }
}