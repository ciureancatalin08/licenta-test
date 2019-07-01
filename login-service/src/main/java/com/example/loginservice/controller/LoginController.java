package com.example.loginservice.controller;


import com.example.loginservice.configuration.BussinesException;
import com.example.loginservice.controller.fingerprint.FingerPrintResource;
import com.example.loginservice.entity.UserEntity;
import com.example.loginservice.entity.dao.UserDao;
import com.example.loginservice.entity.dto.UserConverter;
import com.example.loginservice.entity.dto.UserDto;
import com.example.loginservice.entity.message.MessageCatalog;
import com.example.loginservice.security.JwtGenerator;
import com.example.loginservice.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public  class LoginController {

    @Autowired
    private UserEntity userEntity;


    @Autowired
    private FingerPrintResource fingerPrintResource;


    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDao userDao;

    public String authenticate(UserDto userDto) {


        System.out.println(userDto.getUserName());
        System.out.println(userDto.getFingerprintPath());

        if (userDto.getFingerprintPath() != null) {
            userDto.setFingerTemplate(fingerPrintResource.createTemplate(userDto.getFingerprintPath()));
            UserEntity userByFinger = fingerPrintResource.verifyFingerprint(userDto.getFingerTemplate());
            if (userByFinger != null) {
                return (jwtGenerator.generate(userByFinger));
            } else {
                throw new BussinesException(MessageCatalog.USER_WITH_INVALID_CREDENTIALS);
            }
        } else if (userDao.verifyUser(userConverter.convertInputDTOtoEntity(userDto))) {
            return (jwtGenerator.generate(userConverter.convertInputDTOtoEntity(userDto)));
        } else {
            throw new BussinesException(MessageCatalog.USER_WITH_INVALID_CREDENTIALS);
        }
    }


}
