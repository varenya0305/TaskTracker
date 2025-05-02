package com.iorta.sboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import com.iorta.sboot.dao.TaskTrackerDAO;

public interface TaskTrackerRepository extends JpaRepository<TaskTrackerDAO, Long>{
	List<TaskTrackerDAO> findByCompleted(boolean completed);
}
