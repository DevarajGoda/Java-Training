package com.UserTaskManagementApplication.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.UserTaskManagementApplication.entity.Project;
import com.UserTaskManagementApplication.entity.Task;

public class InMemoryProjectRepository implements ProjectRepository {

	private Map<Long, Project> projects = new HashMap<>();

	private Long idCounter = 1L;

	@Override
	public Project save(Project project) {
		if (project.getProjectId() == null) {
			project.setProjectId(idCounter);
		}
		projects.put(project.getProjectId(), project);
		return project;
	}

	@Override
	public Project findById(Long id) {
		return projects.get(id);
	}

	@Override
	public List<Project> findAll() {
		return new ArrayList<>(projects.values());
	}

	@Override
	public void deleteById(Long id) {
		projects.remove(id);
	}
}