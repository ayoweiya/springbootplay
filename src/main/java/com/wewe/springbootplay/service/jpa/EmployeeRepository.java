package com.wewe.springbootplay.service.jpa;


import com.wewe.springbootplay.module.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
