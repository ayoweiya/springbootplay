package com.wewe.springbootplay.service.iml;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;
import com.wewe.springbootplay.service.AccountService;
import com.wewe.springbootplay.service.jpa.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MyServiceImpl  {

    public int rrrr() throws Exception{
        int i = 80;

        try {
            i= i/0;
        }catch (Exception e){
            e.printStackTrace();
//            throw  e;

            return i;
        }
        return i;
    }


    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
