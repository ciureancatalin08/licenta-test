package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="login-service")
public interface LoginClient {
    @PostMapping("/user/login")
    public String login(UserDto userDto);
}
