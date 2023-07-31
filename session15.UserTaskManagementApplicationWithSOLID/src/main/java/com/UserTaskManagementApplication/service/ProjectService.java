package com.UserTaskManagementApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserTaskManagementApplication.entity.Project;
import com.UserTaskManagementApplication.entity.Task;
@Service
public interface ProjectService {
	
	public Project createProject(Project project);
	
	public Project updateProject(Long projectId, Project project);
	
	public Project getProjectId(Long projectId);
	
	public List<Project> getAllProjects();
	
	public void deleteProject(Long projectId);

}