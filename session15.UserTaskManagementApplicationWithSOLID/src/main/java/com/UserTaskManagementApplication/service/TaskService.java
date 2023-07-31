package com.UserTaskManagementApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserTaskManagementApplication.Enum.PriorityLevel;
import com.UserTaskManagementApplication.entity.Project;
import com.UserTaskManagementApplication.entity.Task;

@Service
public interface TaskService {

	public Task createTask(Task task);

	public Task updateTask(Long id, Task task);

	public Task getTaskId(Long id);

	public List<Task> getPriorityTask(PriorityLevel priorityLevel);

	public List<Task> getAllTask();

	public void markTaskAsCompleted(Long id);

	public void deleteTask(Long id);

}
