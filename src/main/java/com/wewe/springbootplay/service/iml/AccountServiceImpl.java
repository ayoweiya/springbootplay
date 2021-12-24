package com.wewe.springbootplay.service.iml;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;
import com.wewe.springbootplay.service.jpa.AccountRepository;
import com.wewe.springbootplay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    private AccountRepository repository;

//    @Override
//    public Account save(Account account) {
//        return repository.save(account);
//    }

    @Override
    public List<Account> findByCustomer(Customer customer)  {

        TypedQuery query = em.createQuery("select a from Account a where a.customer = ?1", Account.class);
        query.setParameter(1, customer);
        return query.getResultList();
    }
}
