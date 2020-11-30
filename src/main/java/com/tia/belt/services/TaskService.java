package com.tia.belt.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia.belt.models.Priority;
import com.tia.belt.models.Task;
import com.tia.belt.models.User;
import com.tia.belt.repositories.PriorityRepository;
import com.tia.belt.repositories.TaskRepository;
import com.tia.belt.repositories.UserRepository;

@Service
public class TaskService {
	
	@Autowired
    private UserRepository userRepository;
    
    private TaskRepository taskRepository;
    
    private PriorityRepository priorityRepository;
    
    
    public TaskService(UserRepository userRepository, TaskRepository taskRepository, PriorityRepository priorityRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        
    }
 
   
    // returns all the books
    public List<Task> allTasks() {
        return (List<Task>) taskRepository.findAll();
    }
    public List<User>allUsers(){
    	return (List<User>) userRepository.findAll();
    }
    public List<Priority>allPriorities(){
    	return(List<Priority>) priorityRepository.findAll();
    }
   
    //public Task createTask(Event event, User host) {
    //	event.setHost(host);
    //    return taskRepository.save(event);
    //}
    public Task createTask(Task task) {
    	return taskRepository.save(task);
    }
    
    public Task save(Task b) {
    	return taskRepository.save(b);
    }
    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }
    public Priority save(Priority b) {
    	return priorityRepository.save(b);
    }
    public Task findTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
    }
    public Priority findPriority(Long id) {
        Optional<Priority> optionalPriority = priorityRepository.findById(id);
        if(optionalPriority.isPresent()) {
            return optionalPriority.get();
        } else {
            return null;
        }
    }
    
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    public Task updateTask(Task task) {
    	return taskRepository.save(task);
    	
    }
    
  

    
  
    

		
	

 
}