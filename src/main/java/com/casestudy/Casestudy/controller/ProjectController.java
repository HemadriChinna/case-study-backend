package com.casestudy.Casestudy.controller;

import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.Project;
import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("saveProjects")
    public List<Project>saveProjects(@RequestBody List<Project>projectList) {
        return projectService.saveProjctData(projectList);
    }
    @GetMapping("/getProjects")
    public List<Project>getProjects() {
        return projectService.getProjects();
    }
    @GetMapping("/getProjectbyId/{pid}")
    public Project getProjectById(@PathVariable Integer pid) {

        return projectService.getProjectsById(pid);
    }
    @GetMapping("/employees/projects/{email}")
    public List<WorkFromHome> getEmployeesInProjects(@PathVariable String email) {
        List<WorkFromHome> employeesInProjects = projectService.getWorkFromHomeRecordsForEmployeesInProjects(email);
        return (employeesInProjects);
    }
    @DeleteMapping("/deleteProjectbyId/{pid}")
    public void deleteProject(@PathVariable("pid") Integer pid){
        projectService.deleteProject(pid);
    }
}
