package com.accenture.assessmenttest.controllers.v1;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.assessmenttest.controllers.responses.UserDetailResponse;
import com.accenture.assessmenttest.entities.User;
import com.accenture.assessmenttest.entities.UserSetting;
import com.accenture.assessmenttest.serializations.UserSerialization;
import com.accenture.assessmenttest.services.SettingService;
import com.accenture.assessmenttest.services.UserService;

@RestController
public class SettingController {
    
    private final UserService userService;
    private final SettingService settingService;

    public SettingController(UserService userService, SettingService settingService) {
        this.userService = userService;
        this.settingService = settingService;
    }

    @PutMapping("/v1/users/{id}/settings")
    public ResponseEntity<UserDetailResponse> updateSetting(
        @PathVariable Long id, 
        @RequestBody ArrayList<Map<String,String>> userSettings) {
            
            User user = userService.getUser(id);
            List<UserSetting> settings = settingService.updateSettings(user, userSettings);

            UserSerialization userSerialization = UserSerialization.from(user);
            UserDetailResponse response = new UserDetailResponse(userSerialization, settings);
            
            return ResponseEntity.ok(response);
    }

}
