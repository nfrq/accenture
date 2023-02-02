package com.accenture.assessmenttest.serializations;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.accenture.assessmenttest.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSerialization {
    
    private Long id;

    private String ssn;
    
    private String firstName;
    
    private String lastName;

    private LocalDate birthDate;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
    
    private String createdBy;
    
    private String updatedBy;
    
    private Boolean isActive;

    public static UserSerialization from(User user) {
        return new UserSerialization(
            user.getId(), 
            user.getSsn(), 
            user.getFirstName(), 
            user.getLastName(), 
            user.getBirthDate(), 
            user.getCreatedTime(), 
            user.getUpdatedTime(), 
            user.getCreatedBy(), 
            user.getUpdatedBy(), 
            user.getIsActive()
        );
    }

}
