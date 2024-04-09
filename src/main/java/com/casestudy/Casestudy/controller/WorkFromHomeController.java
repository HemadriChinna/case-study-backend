package com.casestudy.Casestudy.controller;

import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.service.WorkFromHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WorkFromHomeController {
    @Autowired
    WorkFromHomeService workFromHomeService;
    @PostMapping("/saveWormFromHomes")
    public List<WorkFromHome>saveWormFromHome(@RequestBody List<WorkFromHome>workFromHomeList){
        return workFromHomeService.saveWormFromHome(workFromHomeList);
    }
    @GetMapping("/getWorkFromHome")
    public List<WorkFromHome>getWorkFromHome() {
        return workFromHomeService.getWorkFromHome();
    }
    @GetMapping("/getWorkFromHomeById/{empId}")
    public List<WorkFromHome>getWorkFromHomeById(@PathVariable("empId") Integer empId) {
        return workFromHomeService.getWorkFromHomeById(empId);
    }
    @GetMapping("/getWorkFromHomeByEmail/{email}")
    public List<WorkFromHome>getWorkFromHomeByEmail(@PathVariable("email") String email) {
        return workFromHomeService.getWorkFromHomeByEmail(email);
    }
    @PutMapping("/approve/{requestId}")
    public WorkFromHome approveRequest(@PathVariable("requestId") Integer requestId) {
        return workFromHomeService.approveRequest(requestId);
    }
    @PutMapping("reject/{requestId}")
    public  WorkFromHome rejectRequest(@PathVariable("requestId") Integer requestId) {
        return workFromHomeService.rejectRequest(requestId);
    }
    @DeleteMapping("/deleteWFH/{id}")
    public void deleteWFH(@PathVariable("id") Integer id) {
        workFromHomeService.deleteWFH(id);
    }
}
