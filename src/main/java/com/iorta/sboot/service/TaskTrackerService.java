package com.iorta.sboot.service;

import java.util.List;

import com.iorta.sboot.dto.TaskTrackerDTO;

public interface TaskTrackerService {
	String createTask(TaskTrackerDTO taskDTO);
	
	List<TaskTrackerDTO> getAllTasks();
	
	TaskTrackerDTO getTaskById(Long id);
	
	String updateTask(Long id, TaskTrackerDTO taskDTO);
	
	String deleteTask(Long id);
	
	List<TaskTrackerDTO> getTaskByStatus(boolean completed);
}


