package com.casestudy.Casestudy.controller;

import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.entity.WorkFromHomeTask;
import com.casestudy.Casestudy.service.WorkFromHomeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WorkFromHomeTaskController {
    @Autowired
    WorkFromHomeTaskService workFromHomeTaskService;
    @PostMapping("/saveWorkFromHomeTasks/{id}")
    public WorkFromHomeTask saveWormFromHomeTask(@RequestBody WorkFromHomeTask workFromHomeTaskList,@PathVariable("id") Integer id) {
        return workFromHomeTaskService.saveWorkFromHomeTask(workFromHomeTaskList,id);
    }
    @GetMapping("/getWorkFromTasks/{id}")
    public List<WorkFromHomeTask> workFromHomeTaskList(@PathVariable("id") Integer id) {
        return workFromHomeTaskService.workFromHomeTaskList(id);
    }
    @PutMapping("saveWorkFromTask/{id}")
    public WorkFromHomeTask workFromHomeTask(@RequestBody WorkFromHomeTask workFromHomeTask ,@PathVariable("id") Integer id){
        return workFromHomeTaskService.saveWorkFromHomeTasks(workFromHomeTask,id);
    }
    @PutMapping("approveTask/{id}")
    public WorkFromHomeTask approvetask(@PathVariable("id") Integer id) {
        return workFromHomeTaskService.approvetask(id);
    }
}
