package com.example.loginservice.facade;


import com.example.loginservice.controller.LoginController;
import com.example.loginservice.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

    @Autowired
    private LoginController loginController;
    public  String authenticateUser(UserDto userDto){
        return loginController.authenticate(userDto);
    }
}
