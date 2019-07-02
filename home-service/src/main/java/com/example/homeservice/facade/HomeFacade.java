package com.example.homeservice.facade;

import com.example.homeservice.controller.HomeController;
import com.example.homeservice.entity.dto.UserHomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeFacade {
    @Autowired
    HomeController homeController;
    public  String addUser(UserHomeDto userHomeDto){
        return homeController.save(userHomeDto);
    }

    public String lightsControl(String state){
     return homeController.lightsController(state);
    };
    public String fansControl(String state){
        return homeController.fansController(state);
    };
    public String alarmsControl(String state){
        return homeController.alarmsController(state);
    };
}

