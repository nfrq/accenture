package com.accenture.assessmenttest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.accenture.assessmenttest.entities.User;
import com.accenture.assessmenttest.entities.UserSetting;
import com.accenture.assessmenttest.entities.enums.SettingKey;
import com.accenture.assessmenttest.repositories.UserSettingRepository;

@Service
public class SettingService {
    
    private final UserSettingRepository userSettingRepository;

    public SettingService(UserSettingRepository userSettingRepository) {
        this.userSettingRepository = userSettingRepository;
    }

    public List<UserSetting> setupDefaults(User user) {
        List<UserSetting> settings = new ArrayList<>();
        for(SettingKey settingKey : SettingKey.values()) {
            UserSetting setting = setupDefault(user, settingKey);
            settings.add(setting);
        }

        return settings;
    }

    public UserSetting setupDefault(User user, SettingKey settingKey) {
        UserSetting setting = new UserSetting(user, settingKey);
        return userSettingRepository.save(setting);
    }

    public List<UserSetting> updateSettings(User user, List<Map<String,String>> userSettings) {
        List<UserSetting> settings = new ArrayList<>();
        for(Map<String,String> userSetting : userSettings) {
            for(Map.Entry<String,String> entry : userSetting.entrySet()) {
                UserSetting setting = userSettingRepository.findBySettingKey(user, entry.getKey());
                setting.setValue(entry.getValue());
                UserSetting updatedSetting = userSettingRepository.save(setting);
                
                settings.add(updatedSetting);
            }
        }

        return settings;
    }

}
