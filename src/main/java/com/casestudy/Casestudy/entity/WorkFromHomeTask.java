package com.casestudy.Casestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Entity
@Data
public class WorkFromHomeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate taskDate;
    private String task;
    private LocalTime startTime;
    private LocalTime endTime;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus=ApplicationStatus.PENDING;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private WorkFromHome workFromHome;
}
