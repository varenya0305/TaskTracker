package com.iorta.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.TaskTrackerDTO;
import com.iorta.sboot.service.TaskTrackerService;

@RestController
@RequestMapping("/task")
public class TaskTrackerController {
	
	@Autowired
	private TaskTrackerService taskService;
	
	@PostMapping("/createTask")
	public String createTask(@RequestBody TaskTrackerDTO taskDTO) {
		return taskService.createTask(taskDTO);
	}
	
	@GetMapping("/getAllTasks")
	public List<TaskTrackerDTO> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/getTaskById/{id}")
	public TaskTrackerDTO getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	@PutMapping("/updateTask/{id}")
	public String updateTask(@PathVariable Long id, @RequestBody TaskTrackerDTO taskDTO) {
		return taskService.updateTask(id, taskDTO);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable Long id) {
		return taskService.deleteTask(id);
	}
	
	@GetMapping("/status/{completed}")
	public List<TaskTrackerDTO> getTasksByStatus(@PathVariable boolean completed) {
		return taskService.getTaskByStatus(completed);
	}
	
}
