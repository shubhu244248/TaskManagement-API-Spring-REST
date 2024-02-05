package com.tasks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.model.Task;
import com.tasks.service.ITaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@PostMapping("/savetask")
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTasks(task);
	}

	@GetMapping("/alltasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/deletetask")
	public ResponseEntity<String> deleteTask(@RequestParam Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.ok("Task deleted successfully");
	}

	@GetMapping("/changestatus")
	public ResponseEntity<String> changeTaskStatus(@RequestParam Long id, @RequestParam String newStatus) {

		Optional<Task> optionalTask = taskService.getTaskById(id);

		if (optionalTask.isPresent()) {
			Task task = optionalTask.get();
			task.setTaskStatus(newStatus);
			taskService.saveTasks(task); // Save the updated task

			return ResponseEntity.ok("Task status changed to '" + newStatus + "' successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
