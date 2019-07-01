package com.example.dbservice.controller;

import com.example.dbservice.configuration.BussinesException;
import com.example.dbservice.controller.fingerprint.FingerPrintResource;
import com.example.dbservice.entity.dao.RegisterDao;
import com.example.dbservice.entity.dto.UserConverter;
import com.example.dbservice.entity.dto.UserDto;
import com.example.dbservice.entity.message.MessageCatalog;
import com.example.dbservice.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public  class RegisterController {


    @Autowired
    private FingerPrintResource fingerPrintResource;


    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RegisterDao registerDao;

    public String signUp(UserDto userDto) {

        if (userDto.getFingerprintPath() != null) {
            userDto.setFingerTemplate(fingerPrintResource.createTemplate(userDto.getFingerprintPath()));
        }
        System.out.println(userDto.getFirstName());
        System.out.println(userDto.getLastName());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getUserName());
        System.out.println(userDto.getRole());
        System.out.println(userDto.getPassword());
        if (!registerDao.userAlreadyExists(userDto.getUserName())) {
            if (userDto.getFingerprintPath() != null) {
                if (fingerPrintResource.verifyFingerprint(userDto.getFingerTemplate()) == null) {
                    registerDao.saveUser( userConverter.convertInputDTOtoEntity(userDto));
                    return (jwtGenerator.generate( userConverter.convertInputDTOtoEntity(userDto)));
                } else {
                    throw new BussinesException(MessageCatalog.USER_WITH_SAME_FINGERPRINT_EXISTS);
                }
            } else {

                registerDao.saveUser( userConverter.convertInputDTOtoEntity(userDto));
                return (jwtGenerator.generate( userConverter.convertInputDTOtoEntity(userDto)));
            }
        }  else {
            throw new BussinesException(MessageCatalog.USER_WITH_SAME_USERNAME_EXISTS);
        }

    }
}
