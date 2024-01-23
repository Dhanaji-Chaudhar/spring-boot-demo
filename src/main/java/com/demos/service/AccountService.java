package com.demos.service;

import com.demos.pojo.Account;
import com.demos.repo.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private SequenceService sequenceService;

    public boolean addToList(Account account) {
        List<Account> accountList = new ArrayList<>();
        return accountList.add(account);
    }

    public Account getAccountDetails(long accountid) {
        return accountRepository.findAccountByAccountId(accountid);

    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByType(String accountType) {
        return accountRepository.findByAccountTypeContaining(accountType);
    }

    public Optional<Account> createNewAccount(Account accountRequest) {
        long id = sequenceService.generateSequence(Account.SEQUENCE_NAME);
        accountRequest.setAccountId(id);
        return Optional.of(accountRepository.save(accountRequest));
    }

}
