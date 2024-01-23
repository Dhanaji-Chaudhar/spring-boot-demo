package com.demos.controller;

import com.demos.pojo.Account;
import com.demos.repo.AccountRepository;
import com.demos.service.AccountService;
import com.demos.service.SequenceService;
import com.demos.util.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/get/{accountid}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable long accountid) {
        return ResponseEntity.ok(accountService.getAccountDetails(accountid));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @GetMapping("/all/byAccountType")
    public ResponseEntity<List<Account>> getAccountsByType(@RequestParam("accountType") String accountType) {
        return ResponseEntity.ok(accountService.getAccountsByType(accountType));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewAccount(@RequestBody Account accountRequest) {
        AccountValidator.validateAccountRequest(accountRequest);
        Optional<Account> account =  accountService.createNewAccount(accountRequest);
        if (account.isPresent())
            return ResponseEntity.ok("Account created " + account.toString());
        else
            return ResponseEntity.ofNullable("Account creation failed");
    }
}
