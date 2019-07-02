package com.example.homeservice.resource;

import com.example.homeservice.entity.dto.UserHomeDto;
import com.example.homeservice.facade.HomeFacade;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeResource {
    @Autowired
    HomeFacade homeFacade;
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody UserHomeDto userHomeDto) {
        return new ResponseEntity<>(JSONObject.quote(homeFacade.addUser(userHomeDto)), HttpStatus.OK);

    }
}