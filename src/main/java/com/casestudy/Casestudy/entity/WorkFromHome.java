package com.casestudy.Casestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Entity
@Data
public class WorkFromHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer employeeId;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus=ApplicationStatus.PENDING;
    @OneToMany(mappedBy = "workFromHome",cascade = CascadeType.ALL)
    private List<WorkFromHomeTask> tasks;
}