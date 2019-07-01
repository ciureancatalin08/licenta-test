package com.example.dbservice.entity.dto;

import com.example.dbservice.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserConverter {
    public UserEntity convertInputDTOtoEntity(UserDto userInputDTO) {
        final UserEntity u = new UserEntity();
        u.setFirstName(userInputDTO.getFirstName());
        u.setLastName(userInputDTO.getLastName());
        u.setUserName(userInputDTO.getUserName());
        u.setEmail(userInputDTO.getEmail());
        u.setPassword(userInputDTO.getPassword());
        u.setRole(userInputDTO.getRole());
        u.setFingerprintPath(userInputDTO.getFingerprintPath());
        u.setFingerPrintTemplate(userInputDTO.getFingerTemplate());
        return u;
    }

//    public UserDTO convertEntityDTO(UserEntity userEntity) {
//        final UserDTO u = new UserDTO();
//        u.setId(userEntity.getId());
//        u.setUserName(userEntity.getUsername());
//        u.setFirstName(userEntity.getFirstName());
//        u.setLastName(userEntity.getLastName());
//        u.setEmail(userEntity.getEmail());
//        u.setMobileNumber(userEntity.getMobileNumber());
//        u.setStatus(userEntity.getStatus());
//        u.setRoles(new ArrayList<>(userEntity.getRoles()));
//        return u;
//    }
}
