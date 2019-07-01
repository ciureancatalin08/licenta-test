package com.example.homeservice.dto;

import com.example.homeservice.home.Home;
import org.springframework.stereotype.Component;

@Component
public class UserHomeConverter {
    public Home convertInputDTOtoEntity(UserHomeDto userHomeDto) {
        final Home home = new Home();
        home.setUserId(userHomeDto.getId());
        home.setUserName(userHomeDto.getUserName());
        home.setTemperature(0);
        home.setHumidity(0);
        home.setHeatIndex(0);
        home.setLights(false);
        home.setCoolingFans(false);
        home.setAlarms(false);
        return home;
    }
}
