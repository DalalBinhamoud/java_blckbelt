package com.dalal.taskManager.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dalal.taskManager.models.Task;


@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{
	List<Task> findAll();
	List<Task> findAllByOrderByPriorityAsc();
	List<Task> findAllByOrderByPriorityDesc();
}
