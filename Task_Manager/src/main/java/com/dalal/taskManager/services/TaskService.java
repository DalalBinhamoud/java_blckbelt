package com.dalal.taskManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.dalal.taskManager.models.Task;
import com.dalal.taskManager.repositories.TaskRepository;

@Service
public class TaskService {
	
	 private final TaskRepository taskRepository;
	 
	    public TaskService(TaskRepository taskRepository) {
	        this.taskRepository = taskRepository;
	    }
	    
	    public void createTask(Task n) {
	    	taskRepository.save(n);
	    }
	    
	    
	    public List<Task> allTasks() {
	        return taskRepository.findAll();
	    }
	    
	    public List<Task> allTasksAsc() {
	        return taskRepository.findAllByOrderByPriorityAsc();
	    }
	    
	    public List<Task> allTasksDesc() {
	        return taskRepository.findAllByOrderByPriorityDesc();
	    }
	    
	    
	
	    public Task TasksForUser(Long id) {
	        Optional<Task> optionalTask = taskRepository.findById(id);
	        if(optionalTask.isPresent()) {
	            return optionalTask.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Task findTask(Long id) {
	        Optional<Task> optionalTask = taskRepository.findById(id);
	        if(optionalTask.isPresent()) {
	            return optionalTask.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Task updateTask(Task task) {
	    	
	    	Task updated_Task = this.findTask(task.getId());
	 	   
	    	updated_Task.setTitle(task.getTitle());
	    	updated_Task.setUser(task.getUser());
	    	updated_Task.setPriority(task.getPriority());
	 	   
	         return taskRepository.save(updated_Task);
	     }

	 public void deleteTask(Long id) {
		 taskRepository.deleteById(id);
	 }

}


