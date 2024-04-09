package com.casestudy.Casestudy.service;

import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.EmployeePrincipal;
import com.casestudy.Casestudy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Employee employee = employeeRepository.findByemail(username);
        if (employee == null) {
            System.out.println("Enter Properly");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new EmployeePrincipal(employee);
    }
}
