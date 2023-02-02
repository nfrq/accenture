package com.accenture.assessmenttest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.assessmenttest.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
    
    @Query(value = "SELECT * FROM USERS u LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<User> findAll(int offset, int limit);
    
}
