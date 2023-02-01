package com.accenture.assessmenttest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_settings")
@Data
public class UserSetting {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "setting_key", nullable = false, length = 100)
    private String key;

    @Column(name = "setting_value", nullable = false, length = 100)
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

}
