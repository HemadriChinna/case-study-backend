package com.casestudy.Casestudy.controller;

import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.Project;
import com.casestudy.Casestudy.repository.EmployeeRepository;
import com.casestudy.Casestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;
    @PostMapping("/saveEmployees")
    public List<Employee>saveEmployees(@RequestBody List<Employee>employeeList) {
        return employeeService.saveEmployeeData(employeeList);
    }
    @GetMapping("/getEmployees")
    public List<Employee>getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/getEmployeebyId/{empId}")
    public Employee getEmployeebyId(@PathVariable("empId") Integer empId) {
        return employeeService.getEmployeebyId(empId);
    }
    @GetMapping("/getEmployeeByDesignation/{role}")
    public List<Employee>getEmployeeByrole(@PathVariable("role") String role) {
        return employeeService.getEmployeeByDesignation(role);
    }
    @PutMapping("{empid}/project/{pid}")
    public Employee assignProjecttoEmployee(@PathVariable("empid") Integer empId,@PathVariable("pid") Integer projectId) {
        return employeeService.assignProjecttoEmployee(empId,projectId);
    }
    @GetMapping("{empid}/projects")
    public Set<Project> assignedProjects(@PathVariable("empid") Integer empid) {
        return employeeService.assignedProjects(empid);
    }
    @GetMapping("email/{email}")
    public Employee getEmployeebyEmail(@PathVariable("email") String email) {
        return employeeService.getEmployeebyEmail(email);
    }
    @DeleteMapping("deleteEmployee/{empId}")
    public void deleteEmployee(@PathVariable("empId") Integer empId) {
        employeeService.deleteEmployee(empId);
    }
}