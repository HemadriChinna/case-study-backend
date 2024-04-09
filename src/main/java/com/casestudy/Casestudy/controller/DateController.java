package com.casestudy.Casestudy.controller;

import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.entity.WorkFromHomeTask;
import com.casestudy.Casestudy.repository.WorkFromHomeRepository;
import com.casestudy.Casestudy.repository.WorkFromHomeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DateController {
    @Autowired
    WorkFromHomeTaskRepository workFromHomeTaskRepository;
    @Autowired
    WorkFromHomeRepository workFromHomeRepository;
    @GetMapping("/calculateDates/{startDate}/{endDate}/{id}")
    public void calculateDates(
            @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @PathVariable("id") Integer id) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = startDate;
        List<WorkFromHomeTask> workFromHomeTaskList = new ArrayList<>();
        WorkFromHome workFromHome = workFromHomeRepository.findById(id).get();
        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate);
            WorkFromHomeTask workFromHomeTask = new WorkFromHomeTask();
            workFromHomeTask.setTaskDate(currentDate);
            workFromHomeTaskList.add(workFromHomeTask);
            workFromHomeTask.setWorkFromHome(workFromHome);
            currentDate = currentDate.plusDays(1); // Move this line here
        }
        workFromHomeTaskRepository.saveAll(workFromHomeTaskList);
    }
}
