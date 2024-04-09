package com.casestudy.Casestudy.service;

import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.Project;
import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.repository.EmployeeRepository;
import com.casestudy.Casestudy.repository.ProjectRepository;
import com.casestudy.Casestudy.repository.WorkFromHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WorkFromHomeRepository workFromHomeRepository;
    @Autowired
    private WorkFromHome workFromHome;
    public List<Project> saveProjctData(List<Project> projectList) {
        return projectRepository.saveAll(projectList);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectsById(Integer pid) {
        return projectRepository.findById(pid).get();
    }

    public void deleteProject(Integer pid) {
        projectRepository.delete(projectRepository.findById(pid).get());
    }
    public List<WorkFromHome> getWorkFromHomeRecordsForEmployeesInProjects(String email) {
        Employee employee = employeeRepository.findByemail(email);
        if (employee != null) {
            Set<Project> projects = employee.getProjectsList();
            Set<Employee> employeesInProjects = new HashSet<>();
            for (Project project : projects) {
                employeesInProjects.addAll(project.getEmployeesList());
            }
            Set<String> employeeEmails = new HashSet<>();
            for (Employee employees : employeesInProjects) {
                employeeEmails.add(employees.getEmail());
            }
            Set<WorkFromHome> workFromHomeRecords = new HashSet<>();
            for (String emails : employeeEmails) {
                workFromHomeRecords.addAll(workFromHomeRepository.findByemail(emails));
            }

            return new ArrayList<>(workFromHomeRecords);
        } else {
            return Collections.emptyList();
        }
    }
}
