package com.example.homeservice.entity.dao;

import com.example.homeservice.entity.HomeEntity;
import com.example.homeservice.entity.dto.HomeDataDto;
import com.example.homeservice.entity.dto.StateDto;
import com.example.homeservice.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeDao {
    @Autowired
    HomeService homeService;

    public String save(HomeEntity homeEntity) {

        homeService.saveUser(homeEntity);
        return "Record added";

    }

    public String setLights(StateDto stateDto) {
        homeService.setLights(stateDto);
        return "Lights updated";

    }

    public String setFans(StateDto stateDto) {
        homeService.setFans(stateDto);
        return "Fans updated";
    }

    public String setAlarms(StateDto stateDto) {
        homeService.setAlarms(stateDto);
        return "Alarms updated";
    }

    public void setData(HomeDataDto homeDataDto) {
        homeService.setData(homeDataDto);
    }
    public HomeEntity getData(String userName) {
        return homeService.getData(userName);
    }
}