package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.clients.RegisterClient;
import com.example.springbootzuulgatwayproxy.dto.UserDto;
import com.example.springbootzuulgatwayproxy.utilities.ImageSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Component
public class RegisterController {
    UserDto userDto;
    @Autowired
    private RegisterClient registerClient;
    public String registerUser( UserDto userDto){
        return registerClient.register(userDto);
    }

}
