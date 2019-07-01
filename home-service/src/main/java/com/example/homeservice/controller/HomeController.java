package com.example.homeservice.controller;

import com.example.homeservice.dto.UserHomeConverter;
import com.example.homeservice.dto.UserHomeDto;
import com.example.homeservice.home.Home;
import com.example.homeservice.services.HomeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/test")
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    UserHomeConverter userHomeConverter;

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody UserHomeDto userHomeDto) {
        System.out.println("i'm here ");
        System.out.println(userHomeDto.getId());
        System.out.println(userHomeDto.getUserName());
        homeService.saveUser(userHomeConverter.convertInputDTOtoEntity(userHomeDto));

        System.out.println("request received");
        return new ResponseEntity<>(JSONObject.quote("Ok"), HttpStatus.OK);
    }
}
//@PostMapping("/{temperature}")
//public void save(@PathVariable int temperature){
//    System.out.println(temperature);
//}
//
//    }
