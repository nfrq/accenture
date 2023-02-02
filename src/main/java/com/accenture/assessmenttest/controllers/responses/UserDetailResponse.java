package com.accenture.assessmenttest.controllers.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accenture.assessmenttest.entities.UserSetting;
import com.accenture.assessmenttest.serializations.UserSerialization;

import lombok.Data;

@Data
public class UserDetailResponse {

    private UserSerialization userData;
    private List<Map<String,String>> userSettings;

    public UserDetailResponse(
        UserSerialization userSerialization, 
        List<UserSetting> userSettings) {

            this.userData = userSerialization;
            setUserSettings(userSettings);
    }

    public void setUserSettings(List<UserSetting> userSettings) {
        this.userSettings = new ArrayList<>();
        for(UserSetting userSetting : userSettings) {
            addUserSetting(userSetting);
        }
    }

    public void addUserSetting(UserSetting userSetting) {
        Map<String,String> setting = new HashMap<>();
        setting.put(userSetting.getKey(), userSetting.getValue());
        
        userSettings.add(setting);
    }

}
