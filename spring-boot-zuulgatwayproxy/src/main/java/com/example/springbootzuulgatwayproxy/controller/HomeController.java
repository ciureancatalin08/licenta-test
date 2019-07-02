package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/rest")

public class HomeController {


    @Autowired
    private HomeClient homeClient;


    @PostMapping(value = "/home/lights")
    public String setLights(@RequestBody String state
    ) {
        return homeClient.setLights(state);
    }

    @PostMapping(value = "/home/fans")
    public String setFans(@RequestBody String state
    ) {
        return homeClient.setFans(state);
    }

    @PostMapping(value = "/home/alarms")
    public String setAlarms(@RequestBody String state
    ) {
        return homeClient.setAlarms(state);
    }


}
