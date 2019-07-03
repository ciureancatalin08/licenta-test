package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.StateDto;
import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="home-service")
    public interface HomeClient {

        @GetMapping("/home/data")
        public String getData(@RequestParam String userName);

        @PostMapping("/home/lights")
        public String setLights(StateDto stateDto);

        @PostMapping("/home/fans")
        public String setFans(StateDto stateDto);

        @PostMapping("/home/alarms")
        public String setAlarms(StateDto stateDto);
    }


