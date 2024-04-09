package com.casestudy.Casestudy.service;

import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.Project;
import com.casestudy.Casestudy.repository.EmployeeRepository;
import com.casestudy.Casestudy.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    ProjectRepository projectRepository;
    public List<Employee> saveEmployeeData(List<Employee> employeeList) {
        for (Employee employee : employeeList){
            String hashedPassword = encoder.encode(employee.getPassword());
            employee.setPassword(hashedPassword);
        }
        return employeeRepository.saveAll(employeeList);
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeebyId(Integer empId) {
        return employeeRepository.findByemployeeId(empId);
    }
    public List<Employee>getEmployeeByDesignation(String designation) {
        return employeeRepository.findBydesignation(designation);
    }

    public Employee assignProjecttoEmployee(Integer empId, Integer projectId) {
        Set<Project> projectSet = new HashSet<Project>();
        Employee employee = employeeRepository.findByemployeeId(empId);
        Project project = projectRepository.findById(projectId).get();
        projectSet = employee.getProjectsList();
        projectSet.add(project);
        employee.setProjectsList(projectSet);
        return employeeRepository.save(employee);
    }

    public Set<Project> assignedProjects(Integer empid) {
        return employeeRepository.findByemployeeId(empid).getProjectsList();
    }

    public void deleteEmployee(Integer empId) {
        Integer id = employeeRepository.findByemployeeId(empId).getId();
        employeeRepository.delete(employeeRepository.findById(id).get());
    }
    public Employee getEmployeebyEmail(String empid) {
        return employeeRepository.findByemail(empid);
    }
}
