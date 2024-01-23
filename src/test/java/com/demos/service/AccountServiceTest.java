package com.demos.service;

import com.demos.pojo.Account;
import com.demos.repo.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void testAddToList() {
        Account mockAccount = mock(Account.class);
        boolean isAdded = accountService.addToList(mockAccount);
        assertTrue(isAdded);
    }

    @Test
    void testGetAccountDetails() {
        Account returnAccount = new Account();
        returnAccount.setAccountId(5L);
        returnAccount.setAccountName("Dhanaji");
        when(accountRepository.findAccountByAccountId(anyLong())).thenReturn(returnAccount);
        Account account = accountService.getAccountDetails(returnAccount.getAccountId());
        Assertions.assertThat(account).isNotNull();
        assertEquals("Dhanaji", account.getAccountName());

    }

    @Test
    void testGetAllAccounts() {
        Account account = new Account();
        account.setAccountId(5L);
        account.setAccountName("Dhanaji");
        List<Account> accountsToBeReturned = new ArrayList<>();
        accountsToBeReturned.add(account);
        when(accountRepository.findAll()).thenReturn(accountsToBeReturned);
        List<Account> accounts = accountService.getAllAccounts();
        Assertions.assertThat(accounts).isNotNull();
        assertEquals(1, accounts.size());
    }

    @Test
    void testGetAccountsByType() {
    }

    @Test
    void testCreateNewAccount() {
    }
}