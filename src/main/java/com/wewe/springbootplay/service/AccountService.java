package com.wewe.springbootplay.service;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;

import java.util.List;

public interface AccountService {
    public Account save(Account account);


    List<Account> findByCustomer(Customer customer);
}
