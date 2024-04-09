package com.casestudy.Casestudy.service;

import com.casestudy.Casestudy.entity.ApplicationStatus;
import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.entity.WorkFromHomeTask;
import com.casestudy.Casestudy.repository.WorkFromHomeRepository;
import com.casestudy.Casestudy.repository.WorkFromHomeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkFromHomeTaskService {
    @Autowired
    WorkFromHomeTaskRepository workFromHomeTaskRepository;
    @Autowired
    WorkFromHomeRepository workFromHomeRepository;

    public WorkFromHomeTask saveWorkFromHomeTask(WorkFromHomeTask workFromHomeTaskList, Integer id) {
        WorkFromHome workFromHome = workFromHomeRepository.findById(id).get();
        workFromHomeTaskList.setWorkFromHome(workFromHome);
        return  workFromHomeTaskRepository.save(workFromHomeTaskList);
    }

    public List<WorkFromHomeTask> workFromHomeTaskList(Integer id) {
        List<WorkFromHomeTask>workFromHomeTaskList;
        workFromHomeTaskList = workFromHomeTaskRepository.findByWorkFromHome_Id(id);
        return workFromHomeTaskList;
    }

    public WorkFromHomeTask saveWorkFromHomeTasks(WorkFromHomeTask workFromHomeTask, Integer id) {
        WorkFromHomeTask workFromHomeTask1 = workFromHomeTaskRepository.findById(id).get();
        workFromHomeTask1.setEndTime(workFromHomeTask.getEndTime());
        workFromHomeTask1.setTask(workFromHomeTask.getTask());
        workFromHomeTask1.setStartTime(workFromHomeTask.getStartTime());
        return workFromHomeTaskRepository.save(workFromHomeTask1);
    }

    public WorkFromHomeTask approvetask(Integer id) {
        WorkFromHomeTask workFromHomeTask = workFromHomeTaskRepository.findById(id).get();
        workFromHomeTask.setApplicationStatus(ApplicationStatus.APPROVED);
        return workFromHomeTaskRepository.save(workFromHomeTask);
    }
}
