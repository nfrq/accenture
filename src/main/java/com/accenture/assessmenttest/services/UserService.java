package com.accenture.assessmenttest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.accenture.assessmenttest.controllers.requests.UserRequest;
import com.accenture.assessmenttest.entities.User;
import com.accenture.assessmenttest.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setSsn(userRequest.getSsn());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setBirthDate(userRequest.getBirthDate());

        return userRepository.save(user);
    }

    public List<User> getUsers(int offset, int limit) {
        return userRepository.findAll(offset, limit);
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User updateUser(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setBirthDate(userRequest.getBirthDate());

        return userRepository.save(user);
    }

    public User softDelete(User user) {
        user.setAsDeleted();
        return userRepository.save(user);
    }

    public User reactivate(User user) {
        user.setAsActive();
        return userRepository.save(user);
    }

}
