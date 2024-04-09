package com.casestudy.Casestudy.repository;

import com.casestudy.Casestudy.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
