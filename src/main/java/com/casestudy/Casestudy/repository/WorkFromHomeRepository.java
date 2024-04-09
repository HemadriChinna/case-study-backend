package com.casestudy.Casestudy.repository;

import com.casestudy.Casestudy.entity.WorkFromHome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkFromHomeRepository extends JpaRepository<WorkFromHome,Integer> {
    List<WorkFromHome>findByemployeeId(Integer employeeId);
    List<WorkFromHome>findByemail(String email);
}