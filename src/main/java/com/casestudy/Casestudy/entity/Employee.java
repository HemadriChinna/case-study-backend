package com.casestudy.Casestudy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer employeeId;
    private String name;
    @Column(unique = true)
    private String phoneNumber;
    private String designation;
    @Column(unique = true)
    private String email;
    private String password;
//    private int enabled;
    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project>projectsList=new HashSet<Project>();
}
