package com.accenture.assessmenttest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.assessmenttest.entities.User;
import com.accenture.assessmenttest.entities.UserSetting;

public interface UserSettingRepository extends CrudRepository<UserSetting,Long> {
    
    @Query("SELECT us FROM UserSetting us WHERE us.user = ?1 AND us.key = ?2")
    UserSetting findBySettingKey(User user, String settingKey);
    
}
