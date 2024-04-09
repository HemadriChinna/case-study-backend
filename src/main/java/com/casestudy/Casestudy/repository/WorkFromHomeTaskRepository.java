package com.casestudy.Casestudy.repository;

import com.casestudy.Casestudy.entity.WorkFromHomeTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkFromHomeTaskRepository extends JpaRepository<WorkFromHomeTask,Integer> {
    List<WorkFromHomeTask> findByWorkFromHome_Id(Integer workFromHomeId);
}
