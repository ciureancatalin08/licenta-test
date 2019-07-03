package com.example.homeservice.facade;

import com.example.homeservice.controller.HomeController;
import com.example.homeservice.entity.dto.HomeDataDto;
import com.example.homeservice.entity.dto.StateDto;
import com.example.homeservice.entity.dto.UserHomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class HomeFacade {
    @Autowired
    HomeController homeController;

    public String addUser(UserHomeDto userHomeDto) {
        return homeController.save(userHomeDto);
    }

    public String lightsControl(StateDto stateDto) {
        return homeController.lightsController(stateDto);
    }

    ;

    public String fansControl(StateDto stateDto) {
        return homeController.fansController(stateDto);
    }

    ;

    public String alarmsControl(StateDto stateDto) {
        return homeController.alarmsController(stateDto);
    }

    public HomeDataDto getData(String userName) {


            return homeController.getData(userName);

    }
}

