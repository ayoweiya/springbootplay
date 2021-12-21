package com.wewe.springbootplay.service.jpa;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCustomer(Customer customer);
}
