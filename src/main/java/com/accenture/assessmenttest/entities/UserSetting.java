package com.accenture.assessmenttest.entities;

import com.accenture.assessmenttest.entities.enums.SettingKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_settings")
@Data
@NoArgsConstructor
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

    public UserSetting(User user, SettingKey key) {
        this.user  = user;
        this.key   = key.toString();
        this.value = key.defaultValue();
    }

}
