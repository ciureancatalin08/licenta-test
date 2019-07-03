package com.example.homeservice.entity.dto;

import com.example.homeservice.entity.HomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class EntityDtoConverter {
    @Autowired
    HomeDataDto homeDataDto;
    public HomeDataDto convertInputDTOtoEntity(HomeEntity homeEntity) {
            homeDataDto.setTemperature(homeEntity.getTemperature());
            homeDataDto.setHumidity(homeEntity.getHumidity());
            homeDataDto.setHeatIndex(homeEntity.getHeatIndex());
            homeDataDto.setAlarms(homeEntity.getAlarms());
            homeDataDto.setFans(homeEntity.getCoolingFans());
            homeDataDto.setLights(homeEntity.getLights());
            return homeDataDto;
        }


}
