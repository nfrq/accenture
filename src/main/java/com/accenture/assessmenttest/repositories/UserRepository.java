package com.accenture.assessmenttest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.accenture.assessmenttest.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
    
}
