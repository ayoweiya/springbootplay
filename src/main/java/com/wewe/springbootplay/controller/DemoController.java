package com.wewe.springbootplay.controller;

import com.wewe.springbootplay.module.Account;
import com.wewe.springbootplay.module.Customer;
import com.wewe.springbootplay.module.Employee;
import com.wewe.springbootplay.module.Gender;
import com.wewe.springbootplay.service.iml.AccountServiceImpl;
import com.wewe.springbootplay.service.iml.MyServiceImpl;
import com.wewe.springbootplay.service.jpa.AccountRepository;
import com.wewe.springbootplay.service.jpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DemoController {
    @Autowired
    EmployeeRepository repository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MyServiceImpl myService;


    @RequestMapping("/temp")
    public String index(Model model)  {
        Employee e1 = new Employee();
        e1.setFirstName("Tomcat");
        e1.setLastName("Foster");
        e1.setGender(Gender.M);  //enum對映varchar
        e1.setBirthDate(LocalDate.of(1990, 1, 1));
        e1.setHireDate(LocalDate.now());

        repository.save(e1);


        Customer customer =  new Customer();
        customer.setId(1L);
        List<Account> accList = accountRepository.findByCustomer(customer);

        for(Account account1:accList){
            System.out.println("-----" + account1.getCustomer());
        }
        return "temp";
    }

    @RequestMapping("/ttt")
    public String ttt(Model model)throws Exception {
        myService.rrrr();
        return "temp";
    }

}
