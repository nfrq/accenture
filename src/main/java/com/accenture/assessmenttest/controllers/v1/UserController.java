package com.accenture.assessmenttest.controllers.v1;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.assessmenttest.controllers.requests.PaginationRequest;
import com.accenture.assessmenttest.controllers.requests.UserRequest;
import com.accenture.assessmenttest.controllers.responses.PaginationResponse;
import com.accenture.assessmenttest.controllers.responses.UserDetailResponse;
import com.accenture.assessmenttest.entities.User;
import com.accenture.assessmenttest.entities.UserSetting;
import com.accenture.assessmenttest.serializations.UserSerialization;
import com.accenture.assessmenttest.services.SettingService;
import com.accenture.assessmenttest.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;
    private final SettingService settingService;

    public UserController(UserService userService, SettingService settingService) {
        this.userService = userService;
        this.settingService = settingService;
    }

    @GetMapping
    public ResponseEntity<PaginationResponse> getAllUsers(@Valid @RequestBody PaginationRequest paginationRequest) {
        List<User> users = userService.getUsers(paginationRequest.getOffset(), paginationRequest.getMaxRecords());
        
        List<UserSerialization> userSerializations = new ArrayList<>();
        for(User user : users) {
            UserSerialization userSerialization = UserSerialization.from(user);
            userSerializations.add(userSerialization);
        }

        PaginationResponse response = new PaginationResponse(
            userSerializations, 
            paginationRequest.getMaxRecords(), 
            paginationRequest.getOffset()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponse> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        List<UserSetting> settings = user.getUserSettings();
        
        UserSerialization userSerialization = UserSerialization.from(user);
        UserDetailResponse response = new UserDetailResponse(userSerialization, settings);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserDetailResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        List<UserSetting> settings = settingService.setupDefaults(user);
        
        UserSerialization userSerialization = UserSerialization.from(user);
        UserDetailResponse response = new UserDetailResponse(userSerialization, settings);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailResponse> updateUser(
        @PathVariable Long id, 
        @Valid @RequestBody UserRequest userRequest) {
            User user = userService.getUser(id);
            User updatedUser = userService.updateUser(user, userRequest);
            List<UserSetting> settings = updatedUser.getUserSettings();
        
            UserSerialization userSerialization = UserSerialization.from(updatedUser);
            UserDetailResponse response = new UserDetailResponse(userSerialization, settings);

            return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        userService.softDelete(user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/refresh")
    public ResponseEntity<UserDetailResponse> reactivateUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        User reactivatedUser = userService.reactivate(user);
        List<UserSetting> settings = reactivatedUser.getUserSettings();
        
        UserSerialization userSerialization = UserSerialization.from(reactivatedUser);
        UserDetailResponse response = new UserDetailResponse(userSerialization, settings);

        return ResponseEntity.ok(response);
    }

}
