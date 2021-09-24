package com.wewe.springbootplay.controller;

import com.wewe.springbootplay.module.Employee;
import com.wewe.springbootplay.module.Gender;
import com.wewe.springbootplay.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class DemoController {
    @Autowired
    EmployeeRepository repository;

    @RequestMapping("/temp")
    public String index(Model model){
        Employee e1 = new Employee();
        e1.setFirstName("Tomcat");
        e1.setLastName("Foster");
        e1.setGender(Gender.M);
        e1.setBirthDate(LocalDate.of(1990, 1, 1));
        e1.setHireDate(LocalDate.now());

        repository.save(e1);
        return "temp";
    }


}
