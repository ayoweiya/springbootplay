package com.wewe.springbootplay.service;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public List<Account> findByCustomer(Customer customer) {
        return repository.findByCustomer( customer);
    }
}
