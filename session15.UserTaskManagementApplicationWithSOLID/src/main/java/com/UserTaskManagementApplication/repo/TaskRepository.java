package com.UserTaskManagementApplication.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.UserTaskManagementApplication.Enum.PriorityLevel;
import com.UserTaskManagementApplication.entity.Task;

@Repository
public interface TaskRepository {

	public Task save(Task task);

	public Task findById(Long id);

	public List<Task> findByProjectId(Long projectId);

	public List<Task> findByPriority(PriorityLevel priority);

	public List<Task> findAll();

	public void deleteById(Long id);
}
