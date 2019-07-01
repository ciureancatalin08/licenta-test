package com.example.homeservice.services;

import com.example.homeservice.home.Home;
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
    public Home saveUser(Home home) {
        return homeRepository.save(home);
    }
}
