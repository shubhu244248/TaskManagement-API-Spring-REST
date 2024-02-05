package com.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.model.Task;
import com.tasks.repository.TaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTasks(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Optional<Task> getTaskById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public List<Task> getTasksByTaskHolderName(String taskHolderName) {
		// TODO Auto-generated method stub
		return taskRepository.findByTaskHolderName(taskHolderName);
	}

}
