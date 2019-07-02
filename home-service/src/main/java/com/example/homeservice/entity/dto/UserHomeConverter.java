package com.example.homeservice.entity.dto;

import com.example.homeservice.entity.HomeEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHomeConverter {
    public HomeEntity convertInputDTOtoEntity(UserHomeDto userHomeDto) {
        final HomeEntity homeEntity = new HomeEntity();
        homeEntity.setUserId(userHomeDto.getId());
        homeEntity.setUserName(userHomeDto.getUserName());
        homeEntity.setTemperature(0);
        homeEntity.setHumidity(0);
        homeEntity.setHeatIndex(0);
        homeEntity.setLights("OFF");
        homeEntity.setCoolingFans("OFF");
        homeEntity.setAlarms("OFF");
        return homeEntity;
    }
}
