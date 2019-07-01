package com.example.loginservice.entity.dao;


import com.example.loginservice.entity.UserEntity;
import com.example.loginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    UserService userService;
    public boolean verifyUser(UserEntity userEntity){
       return userService.verifyUser(userEntity);
    }

    public boolean userAlreadyExists(String userName){
        return userService.userAlreadyExists(userName);
    }
}
