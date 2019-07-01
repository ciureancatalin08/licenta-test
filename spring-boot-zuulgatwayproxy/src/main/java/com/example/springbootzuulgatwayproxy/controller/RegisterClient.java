package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.UserDto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="register-service")
public interface RegisterClient {
    @PostMapping("/user/signUp")
    public String register(UserDto userDto);
}
