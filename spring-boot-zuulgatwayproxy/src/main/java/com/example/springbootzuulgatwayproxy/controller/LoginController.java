package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.clients.LoginClient;
import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginController {

    @Autowired
    private LoginClient loginClient;
    public String loginUser(UserDto userDto) {
        return loginClient.login(userDto);
    }


}
