package com.casestudy.Casestudy;

import com.casestudy.Casestudy.entity.ApplicationStatus;
import com.casestudy.Casestudy.entity.Employee;
import com.casestudy.Casestudy.entity.WorkFromHome;
import com.casestudy.Casestudy.entity.WorkFromHomeTask;
import com.casestudy.Casestudy.repository.EmployeeRepository;
import com.casestudy.Casestudy.repository.ProjectRepository;
import com.casestudy.Casestudy.repository.WorkFromHomeRepository;
import com.casestudy.Casestudy.repository.WorkFromHomeTaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CasestudyApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CasestudyApplication.class, args);
		System.out.println("Started");
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		ProjectRepository projectRepository = context.getBean(ProjectRepository.class);
		WorkFromHomeTaskRepository workFromHomeTaskRepository = context.getBean(WorkFromHomeTaskRepository.class);
		WorkFromHomeRepository workFromHomeRepository = context.getBean(WorkFromHomeRepository.class);
		System.out.println("Completed");
	}
}