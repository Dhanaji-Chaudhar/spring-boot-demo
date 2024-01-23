package com.demos.repo;

import com.demos.pojo.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account,Integer> {
    public Account findAccountByAccountId(long accountid) ;
    List<Account> findByAccountTypeContaining(String accName);
}
