package com.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasks.model.Task;

@Service
public interface ITaskService {

	public Task saveTasks(Task task);

	public List<Task> getAllTasks();

	void deleteTask(Long id);

	Optional<Task> getTaskById(Long id);

	List<Task> getTasksByTaskHolderName(String taskHolderName);
}
