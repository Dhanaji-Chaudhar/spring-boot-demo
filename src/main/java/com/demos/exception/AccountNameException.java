package com.demos.exception;

import lombok.Getter;
import lombok.Setter;

public class AccountNameException extends RuntimeException {
    @Getter @Setter
    private String message;
    public AccountNameException(String account_name_message) {
        super(account_name_message);
        this.message=account_name_message;
    }
}
