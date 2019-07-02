package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

    @FeignClient(name="home-service")
    public interface HomeClient {
        @PostMapping("/home/lights")
        public String setLights(String state);
    }

