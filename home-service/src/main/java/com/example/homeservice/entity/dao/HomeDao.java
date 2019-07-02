package com.example.homeservice.entity.dao;

import com.example.homeservice.entity.HomeEntity;
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
    public String setLights(String state) {

        homeService.setLights(state);
        return "Lights updated";

    }
}