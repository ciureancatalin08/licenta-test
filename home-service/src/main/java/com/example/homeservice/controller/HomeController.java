package com.example.homeservice.controller;

import com.example.homeservice.home.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/test")
public class HomeController {


//
//
//        @RequestMapping(method = RequestMethod.GET)
//        public Home save() {
////            System.out.println(id);
//            Home home = new Home();
//            home.setTemperature(50);
//            home.setHumidity(30);
//            home.setHeatIndex(16);
//            System.out.println("request received");
//            return home;
//        }
@PostMapping("/{temperature}")
public void save(@PathVariable int temperature){
    System.out.println(temperature);
}

    }
