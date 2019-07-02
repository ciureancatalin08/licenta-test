package com.example.homeservice.controller;

import com.example.homeservice.entity.dao.HomeDao;
import com.example.homeservice.entity.dto.UserHomeConverter;
import com.example.homeservice.entity.dto.UserHomeDto;
import com.example.homeservice.services.HomeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class HomeController {

    @Autowired
    HomeDao homeDao;
    @Autowired
    UserHomeConverter userHomeConverter;


    public String save(@RequestBody UserHomeDto userHomeDto) {
        System.out.println("i'm here ");
        System.out.println(userHomeDto.getId());
        System.out.println(userHomeDto.getUserName());
        System.out.println("request received");
        return homeDao.save(userHomeConverter.convertInputDTOtoEntity(userHomeDto));
    }
}
//@PostMapping("/{temperature}")
//public void save(@PathVariable int temperature){
//    System.out.println(temperature);
//}
//
//    }
