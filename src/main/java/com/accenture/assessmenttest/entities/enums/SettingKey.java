package com.accenture.assessmenttest.entities.enums;

public enum SettingKey {
    
    BIOMETRIC_LOGIN("biometric_login"), 

    PUSH_NOTIFICATION("push_notification"), 

    SMS_NOTIFICATION("sms_notification"), 

    SHOW_ONBOARDING("show_onboarding"), 

    WIDGET_ORDER("widget_order");

    private final String setting;

    SettingKey(String setting) {
        this.setting = setting;
    }

    @Override
    public String toString() {
        return setting;
    }
}
