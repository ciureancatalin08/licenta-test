package com.example.dbservice.entity.dto;

public class UserDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String fingerprintPath;
    private String role;
    private String fingerTemplate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFingerTemplate() {
        return fingerTemplate;
    }

    public void setFingerTemplate(String fingerTemplate) {
        this.fingerTemplate = fingerTemplate;
    }
}
