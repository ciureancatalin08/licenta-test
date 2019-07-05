package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.StateDto;
import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/test")

public class HomeController {


    @Autowired
    private HomeClient homeClient;

    @GetMapping(value = "/home/data")
    public String getData(@RequestParam String userName
    ) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
       }
        return homeClient.getData(userName);
    }


    @PostMapping(value = "/home/lights")
    public String setLights(@RequestBody StateDto stateDto
    ) {

        return homeClient.setLights(stateDto);

    }

    @PostMapping(value = "/home/fans")
    public String setFans(@RequestBody StateDto stateDto
                          ) {

        return homeClient.setFans(stateDto);
    }

    @PostMapping(value = "/home/alarms")
    public String setAlarms(@RequestBody StateDto stateDto
    ) {
        return homeClient.setAlarms(stateDto);
    }


}
