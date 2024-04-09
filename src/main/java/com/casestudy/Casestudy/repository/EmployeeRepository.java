package com.casestudy.Casestudy.repository;

import com.casestudy.Casestudy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByemployeeId(Integer employeeId);
    List<Employee>findBydesignation(String Designation);
    Employee findByemail(String empid);
}