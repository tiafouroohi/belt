package com.tia.belt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tia.belt.models.Task;



public interface TaskRepository extends CrudRepository<Task, Long> {

}