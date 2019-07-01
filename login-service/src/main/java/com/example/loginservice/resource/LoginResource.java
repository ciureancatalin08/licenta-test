package com.example.loginservice.resource;

import com.example.loginservice.entity.dto.UserDto;
import com.example.loginservice.facade.LoginFacade;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class LoginResource {

    @Autowired
    LoginFacade loginFacade;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> authenticate(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(JSONObject.quote(loginFacade.authenticateUser(userDto)), HttpStatus.OK);

    }
}



