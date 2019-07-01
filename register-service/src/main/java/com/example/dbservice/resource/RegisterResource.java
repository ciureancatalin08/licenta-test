package com.example.dbservice.resource;


import com.example.dbservice.entity.dto.UserDto;
import com.example.dbservice.facade.RegisterFacade;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class RegisterResource {

    @Autowired
    RegisterFacade registerFacade;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
        System.out.println("8551");
        return new ResponseEntity<>(JSONObject.quote(registerFacade.authenticateUser(userDto)), HttpStatus.OK);

    }
}



