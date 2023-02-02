package com.accenture.assessmenttest.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
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

    @Column
    private LocalDate birthDate;

    @Column
    private LocalDateTime createdTime = LocalDateTime.now();

    @Column
    private LocalDateTime updatedTime = LocalDateTime.now();

    @Column(nullable = false, length = 100)
    private String createdBy = "SYSTEM";

    @Column(nullable = false, length = 100)
    private String updatedBy = "SYSTEM";
    
    @Column(nullable = false)
    private Boolean isActive = true;
    
    @Column
    private LocalDateTime deletedTime;

    @OneToMany(mappedBy = "user")
    private List<UserSetting> userSettings;

    public void setLastName(String lastName) {
        List<String> splitedLastName = new ArrayList<String>(
            Arrays.asList(lastName.split("\s", 0))
        );

        this.familyName = splitedLastName.remove(splitedLastName.size() - 1);
        this.middleName = String.join(" ", splitedLastName);
    }

    public String getLastName() {
        return String.join(" ", Arrays.asList(middleName, familyName));
    }

    public void setAsDeleted() {
        this.isActive = false;
        this.deletedTime = LocalDateTime.now();
    }

    public void setAsActive() {
        this.isActive = true;
        this.deletedTime = null;
    }

}
