package com.example.homeservice.services;

import com.example.homeservice.entity.HomeEntity;
import com.example.homeservice.entity.dto.HomeDataDto;
import com.example.homeservice.entity.dto.StateDto;
import com.example.homeservice.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public HomeEntity saveUser(HomeEntity homeEntity) {
        return homeRepository.save(homeEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void setLights(StateDto stateDto) {
        homeRepository.setLigths(stateDto.getState(), stateDto.getUserName());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void setFans(StateDto stateDto) {
        homeRepository.setFans(stateDto.getState(),stateDto.getUserName());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void setAlarms(StateDto stateDto) {
        homeRepository.setAlarms(stateDto.getState(),stateDto.getUserName());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void setData(HomeDataDto homeDataDto) {
        homeRepository.setData(homeDataDto.getTemperature(),homeDataDto.getHumidity(),homeDataDto.getHeatIndex(),homeDataDto.getUserName());
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public HomeEntity getData(String userName) {
        return homeRepository.getData(userName);
    }
}
