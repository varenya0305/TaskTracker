package com.iorta.sboot.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.iorta.sboot.dao.TaskTrackerDAO;
import com.iorta.sboot.dto.TaskTrackerDTO;
import com.iorta.sboot.repository.TaskTrackerRepository;
import com.iorta.sboot.service.TaskTrackerService;

@Service
public class TaskTrackerServiceImpl implements TaskTrackerService{
	
	@Autowired
	private TaskTrackerRepository taskRepository;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public String createTask(TaskTrackerDTO taskDTO) {
		TaskTrackerDAO task = mapper.map(taskDTO, TaskTrackerDAO.class);
		taskRepository.save(task);
		return "Task Created Successfully";
	}

	@Override
	public List<TaskTrackerDTO> getAllTasks() {
		List<TaskTrackerDAO> tasks = taskRepository.findAll();
		return tasks.stream()
				.map(task -> mapper.map(task, TaskTrackerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public TaskTrackerDTO getTaskById(Long id) {
		Optional<TaskTrackerDAO> task = taskRepository.findById(id);
		return task.map(t -> mapper.map(t, TaskTrackerDTO.class)).orElse(null);
	}

	@Override
	public String updateTask(Long id, TaskTrackerDTO taskDTO) {
		Optional<TaskTrackerDAO> existingTask = taskRepository.findById(id);
		if (existingTask.isPresent()) {
			TaskTrackerDAO task = existingTask.get();
			task.setTitle(taskDTO.getTitle());
			task.setDescription(taskDTO.getDescription());
			task.setCompleted(taskDTO.isCompleted());
			task.setDueDate(taskDTO.getDueDate());
			taskRepository.save(task);
			return "Task Updated Successfully";
		} else {
			return "Task Not Found";
		}
	}

	@Override
	public String deleteTask(Long id) {
		taskRepository.deleteById(id);
		return "Task Deleted Successfully";
	}

	@Override
	public List<TaskTrackerDTO> getTaskByStatus(boolean completed) {
		return taskRepository.findByCompleted(completed).stream()
				.map(task -> mapper.map(task, TaskTrackerDTO.class))
				.collect(Collectors.toList());
	}

}
