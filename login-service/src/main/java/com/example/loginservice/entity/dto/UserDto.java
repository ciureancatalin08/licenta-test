package com.example.loginservice.entity.dto;

public class UserDto {

    private String userName;

    private String password;
    private String fingerprintPath;

    private String fingerTemplate;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFingerprintPath() {
        return fingerprintPath;
    }

    public void setFingerprintPath(String fingerprintPath) {
        this.fingerprintPath = fingerprintPath;
    }


    public String getFingerTemplate() {
        return fingerTemplate;
    }

    public void setFingerTemplate(String fingerTemplate) {
        this.fingerTemplate = fingerTemplate;
    }
}
