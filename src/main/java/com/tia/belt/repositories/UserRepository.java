package com.tia.belt.repositories;
import org.springframework.data.repository.CrudRepository;

import com.tia.belt.models.User;



public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}