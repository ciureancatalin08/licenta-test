package com.example.dbservice.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Component
public class UserEntity {
    public UserEntity(){}

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;


    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String userName;

    @NotNull//regex
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String role;


    private String fingerprintPath;

    private String fingerPrintTemplate;

    public String getFingerPrintTemplate() {
        return fingerPrintTemplate;
    }

    public void setFingerPrintTemplate(String fingerPrintTemplate) {
        this.fingerPrintTemplate = fingerPrintTemplate;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getFingerprintPath() {
        return fingerprintPath;
    }

    public void setFingerprintPath(String fingerprintPath) {
        this.fingerprintPath = fingerprintPath;
    }



}
