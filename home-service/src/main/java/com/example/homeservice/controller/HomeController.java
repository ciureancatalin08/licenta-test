package com.example.homeservice.controller;

import com.example.homeservice.entity.dao.HomeDao;
import com.example.homeservice.entity.dto.UserHomeConverter;
import com.example.homeservice.entity.dto.UserHomeDto;
import com.example.homeservice.entity.message.MessageCatalog;
import com.example.homeservice.sender.RequestSender;
import com.example.homeservice.services.HomeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public class HomeController {

    @Autowired
    HomeDao homeDao;
    @Autowired
    UserHomeConverter userHomeConverter;
    @Autowired
    RequestSender requestSender;


    public String save(UserHomeDto userHomeDto) {
        return homeDao.save(userHomeConverter.convertInputDTOtoEntity(userHomeDto));
    }
    public String lightsController(String state) {
        if (state.equals("ON")) {
            requestSender.asyncMethodWithReturnType(MessageCatalog.LIGHTS_ON);
            return homeDao.setLights("ON");
        } else {
            requestSender.asyncMethodWithReturnType(MessageCatalog.LIGHTS_OFF);
            return homeDao.setLights("OFF");
        }

    }
//    public String fansController(String state){};
//    public String alarmsController(String state){};
}
//@PostMapping("/{temperature}")
//public void save(@PathVariable int temperature){
//    System.out.println(temperature);
//}
//
//    }
