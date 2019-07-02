package com.example.homeservice.services;

import com.example.homeservice.entity.HomeEntity;
import com.example.homeservice.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
