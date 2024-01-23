package com.demos.util;

import com.demos.exception.AccountNameException;
import com.demos.exception.ApplicationException;
import com.demos.pojo.Account;
import org.springframework.http.HttpStatus;

public class AccountValidator {
    public static void validateAccountRequest(Account account) {
        if (account == null) {
            throw new ApplicationException(HttpStatus.NOT_FOUND.toString(),"Account not found", HttpStatus.NOT_FOUND);
        }
        if (account.getAccountName().isBlank()) {
            throw new ApplicationException(HttpStatus.NOT_FOUND.toString(),"Account name not found", HttpStatus.NOT_FOUND);
        }
    }
}
