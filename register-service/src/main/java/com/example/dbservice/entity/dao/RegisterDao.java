package com.example.dbservice.entity.dao;

import com.example.dbservice.entity.UserEntity;
import com.example.dbservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDao {
    @Autowired
    RegisterService registerService;
    public void saveUser(UserEntity userEntity){
        registerService.saveUser(userEntity);
    }
    public UserEntity getUser(UserEntity userEntity){
        return registerService.getUser(userEntity);
    }
    public boolean userAlreadyExists(String userName){
        return registerService.userAlreadyExists(userName);
    }
}
