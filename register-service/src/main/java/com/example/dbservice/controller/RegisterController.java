package com.example.dbservice.controller;

import com.example.dbservice.configuration.BussinesException;
import com.example.dbservice.controller.fingerprint.FingerPrintResource;
import com.example.dbservice.entity.UserEntity;
import com.example.dbservice.entity.dao.RegisterDao;
import com.example.dbservice.entity.dto.UserConverter;
import com.example.dbservice.entity.dto.UserDto;
import com.example.dbservice.entity.message.MessageCatalog;
import com.example.dbservice.security.JwtGenerator;
import com.example.dbservice.sender.RequestSender;
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

    @Autowired
    RequestSender requestSender;

    public String signUp(UserDto userDto) {

        if (userDto.getFingerprintPath() != null) {
            userDto.setFingerTemplate(fingerPrintResource.createTemplate(userDto.getFingerprintPath()));
        }

        if (!registerDao.userAlreadyExists(userDto.getUserName())) {
            if (userDto.getFingerprintPath() != null) {
                if (fingerPrintResource.verifyFingerprint(userDto.getFingerTemplate()) == null) {
                    registerDao.saveUser( userConverter.convertInputDTOtoEntity(userDto));
                    requestSender.asyncMethodWithReturnType(userConverter.convertEntityToUserHomeDto(registerDao.getUser(userConverter.convertInputDTOtoEntity(userDto))));
                    return (jwtGenerator.generate( userConverter.convertInputDTOtoEntity(userDto)));
                } else {
                    throw new BussinesException(MessageCatalog.USER_WITH_SAME_FINGERPRINT_EXISTS);
                }
            } else {

                registerDao.saveUser( userConverter.convertInputDTOtoEntity(userDto));
                requestSender.asyncMethodWithReturnType(userConverter.convertEntityToUserHomeDto(registerDao.getUser(userConverter.convertInputDTOtoEntity(userDto))));
                return (jwtGenerator.generate( userConverter.convertInputDTOtoEntity(userDto)));
            }
        }  else {
            throw new BussinesException(MessageCatalog.USER_WITH_SAME_USERNAME_EXISTS);
        }

    }
}
