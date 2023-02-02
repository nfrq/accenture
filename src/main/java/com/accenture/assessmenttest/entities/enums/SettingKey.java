package com.accenture.assessmenttest.entities.enums;

public enum SettingKey {
    
    BIOMETRIC_LOGIN("biometric_login", "false"), 

    PUSH_NOTIFICATION("push_notification", "false"), 

    SMS_NOTIFICATION("sms_notification", "false"), 

    SHOW_ONBOARDING("show_onboarding", "false"), 

    WIDGET_ORDER("widget_order", "1,2,3,4,5");

    private final String setting;
    private final String defaultValue;

    SettingKey(String setting, String defaultValue) {
        this.setting = setting;
        this.defaultValue = defaultValue;
    }

    public String defaultValue() {
        return defaultValue;
    }

    @Override
    public String toString() {
        return setting;
    }
    
}
