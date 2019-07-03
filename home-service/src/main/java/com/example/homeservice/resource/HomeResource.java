package com.example.homeservice.resource;

import com.example.homeservice.entity.dto.HomeDataDto;
import com.example.homeservice.entity.dto.StateDto;
import com.example.homeservice.entity.dto.UserHomeDto;
import com.example.homeservice.facade.HomeFacade;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/home")
public class HomeResource {
    @Autowired
    HomeFacade homeFacade;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody UserHomeDto userHomeDto) {
        return new ResponseEntity<>(JSONObject.quote(homeFacade.addUser(userHomeDto)), HttpStatus.OK);

    }

    @RequestMapping(value = "/lights", method = RequestMethod.POST)
    public ResponseEntity<String> lights(@RequestBody StateDto stateDto) {
        System.out.println(stateDto.getState());
        return new ResponseEntity<>(JSONObject.quote(homeFacade.lightsControl(stateDto)), HttpStatus.OK);

    }

    @RequestMapping(value = "/fans", method = RequestMethod.POST)
    public ResponseEntity<String> fans(@RequestBody StateDto stateDto) {
        return new ResponseEntity<>(JSONObject.quote(homeFacade.fansControl(stateDto)), HttpStatus.OK);

    }

    @RequestMapping(value = "/alarms", method = RequestMethod.POST)
    public ResponseEntity<String> alarms(@RequestBody StateDto stateDto) {
        return new ResponseEntity<>(JSONObject.quote(homeFacade.alarmsControl(stateDto)), HttpStatus.OK);

    }
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity<HomeDataDto> getData(@RequestParam String userName) {
        return new ResponseEntity<>(homeFacade.getData(userName), HttpStatus.OK);

    }
}