package com.example.springbootzuulgatwayproxy.facade;

import com.example.springbootzuulgatwayproxy.controller.HomeController;
import com.example.springbootzuulgatwayproxy.controller.LoginController;
import com.example.springbootzuulgatwayproxy.controller.RegisterController;
import com.example.springbootzuulgatwayproxy.dto.StateDto;
import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GatewayFacade {
    @Autowired

    RegisterController registerController;
    @Autowired
    LoginController loginController;

    @Autowired
    HomeController homeController;


    public String registerUser(UserDto userDto) {
        return registerController.registerUser(userDto);
    }

    public String loginUser(UserDto userDto) {
        return loginController.loginUser(userDto);
    }

    public String getData(String userName) {
        return homeController.getData(userName);
    }

    public String setLights(StateDto stateDto) {
        return homeController.setLights(stateDto);
    }

    public String setFans(StateDto stateDto) {
        return homeController.setFans(stateDto);
    }

    public String setAlarms(StateDto stateDto) {
        return homeController.setAlarms(stateDto);
    }
}
