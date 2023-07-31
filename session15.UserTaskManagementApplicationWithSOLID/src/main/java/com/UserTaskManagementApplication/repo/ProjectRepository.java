package com.UserTaskManagementApplication.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.UserTaskManagementApplication.entity.Project;
import com.UserTaskManagementApplication.entity.Task;

@Repository
public interface ProjectRepository {

	public Project save(Project project);

	public Project findById(Long id);

	public List<Project> findAll();

	public void deleteById(Long id);
}
