package com.accenture.assessmenttest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.accenture.assessmenttest.entities.UserSetting;

public interface UserSettingRepository extends CrudRepository<UserSetting,Long> {
    
}
