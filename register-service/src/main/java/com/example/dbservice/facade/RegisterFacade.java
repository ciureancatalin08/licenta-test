package com.example.dbservice.facade;

import com.example.dbservice.controller.RegisterController;
import com.example.dbservice.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterFacade {

    @Autowired
    private RegisterController loginController;
    public  String authenticateUser(UserDto userDto){
        return loginController.signUp(userDto);
    }
}
