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


        UserDto userDto;


        @PostMapping (value = "/home")
        public String setLights( @RequestBody String state
        ){
            return homeClient.setLights(state);
        }







}
