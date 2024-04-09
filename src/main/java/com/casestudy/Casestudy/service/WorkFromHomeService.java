package com.casestudy.Casestudy.service;

import com.casestudy.Casestudy.entity.ApplicationStatus;
import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.repository.WorkFromHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkFromHomeService {
    @Autowired
    WorkFromHomeRepository workFromHomeRepository;
    public List<WorkFromHome> saveWormFromHome(List<WorkFromHome> workFromHomeList) {
        return workFromHomeRepository.saveAll(workFromHomeList);
    }

    public List<WorkFromHome> getWorkFromHome() {
        return workFromHomeRepository.findAll();
    }

    public List<WorkFromHome> getWorkFromHomeById(Integer empId) {
        return workFromHomeRepository.findByemployeeId(empId);
    }
    public List<WorkFromHome> getWorkFromHomeByEmail(String email) {
        return workFromHomeRepository.findByemail(email);
    }

    public void deleteWFH(Integer id) {
        workFromHomeRepository.delete(workFromHomeRepository.findById(id).get());
    }

    public WorkFromHome approveRequest(Integer requestId) {
        WorkFromHome workFromHome = workFromHomeRepository.findById(requestId).get();
            workFromHome.setApplicationStatus(ApplicationStatus.APPROVED);
            return workFromHomeRepository.save(workFromHome);
    }

    public WorkFromHome rejectRequest(Integer requestId) {
        WorkFromHome workFromHome = workFromHomeRepository.findById(requestId).get();
        workFromHome.setApplicationStatus(ApplicationStatus.REJECTED);
        return workFromHomeRepository.save(workFromHome);
    }
}