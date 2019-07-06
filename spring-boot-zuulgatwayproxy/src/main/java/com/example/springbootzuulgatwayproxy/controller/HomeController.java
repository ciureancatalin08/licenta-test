package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.clients.HomeClient;
import com.example.springbootzuulgatwayproxy.dto.StateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;



@Component
public class HomeController {


    @Autowired
    private HomeClient homeClient;

    public String getData(@RequestParam String userName
    ) {
        return homeClient.getData(userName);
    }

    public String setLights(@RequestBody StateDto stateDto
    ) {
        return homeClient.setLights(stateDto);
    }

    public String setFans(@RequestBody StateDto stateDto
    ) {
        return homeClient.setFans(stateDto);
    }


    public String setAlarms(@RequestBody StateDto stateDto
    ) {
        return homeClient.setAlarms(stateDto);
    }


}
