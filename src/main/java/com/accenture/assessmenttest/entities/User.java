package com.accenture.assessmenttest.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 16)
    private String ssn;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(length = 100)
    private String middleName;
    
    @Column(length = 100)
    private String familyName;

    private Date birthDate;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    @Column(nullable = false, length = 100)
    private String createdBy = "SYSTEM";

    @Column(nullable = false, length = 100)
    private String updatedBy = "SYSTEM";
    
    @Column(nullable = false)
    private Boolean isActive = true;
    
    private LocalDateTime deletedTime;

}
