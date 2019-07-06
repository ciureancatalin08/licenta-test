package com.example.homeservice.controller;

import com.example.homeservice.entity.dao.HomeDao;
import com.example.homeservice.entity.dto.*;
import com.example.homeservice.entity.message.MessageCatalog;
import com.example.homeservice.sender.RequestSender;
import com.example.homeservice.services.HomeService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class HomeController {

    @Autowired
    HomeDao homeDao;
    @Autowired
    UserHomeConverter userHomeConverter;
    @Autowired
    RequestSender requestSender;
    @Autowired
    EntityDtoConverter entityDtoConverter;

    public String save(UserHomeDto userHomeDto) {
        return homeDao.save(userHomeConverter.convertInputDTOtoEntity(userHomeDto));
    }

    public String lightsController(StateDto stateDto) {
        if (stateDto.getState().equals("ON")) {
            System.out.println(stateDto.getUserName());
            requestSender.asyncMethodWithReturnType(MessageCatalog.LIGHTS_ON);
            return homeDao.setLights(stateDto);
        } else {
            requestSender.asyncMethodWithReturnType(MessageCatalog.LIGHTS_OFF);
            return homeDao.setLights(stateDto);
        }

    }

    public String fansController(StateDto stateDto) {
        if (stateDto.getState().equals("ON")) {
            requestSender.asyncMethodWithReturnType(MessageCatalog.FANS_ON);
            return homeDao.setFans(stateDto);
        } else {
            requestSender.asyncMethodWithReturnType(MessageCatalog.FANS_OFF);
            return homeDao.setFans(stateDto);
        }

    }

    public String alarmsController(StateDto stateDto) {
        if (stateDto.getState().equals("ON")) {
            requestSender.asyncMethodWithReturnType(MessageCatalog.ALARMS_ON);
            return homeDao.setAlarms(stateDto);
        } else {
            requestSender.asyncMethodWithReturnType(MessageCatalog.ALARMS_OFF);
            return homeDao.setAlarms(stateDto);
        }

    }

    public HomeDataDto getData(String userName) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
//            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        homeDao.setData(requestSender.getData(userName));

        return entityDtoConverter.convertInputDTOtoEntity(homeDao.getData(userName));

    }
}
