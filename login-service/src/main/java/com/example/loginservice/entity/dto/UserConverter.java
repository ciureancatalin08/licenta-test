package com.example.loginservice.entity.dto;


import com.example.loginservice.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertInputDTOtoEntity(UserDto userInputDTO) {
        final UserEntity u = new UserEntity();
        u.setUserName(userInputDTO.getUserName());
        u.setPassword(userInputDTO.getPassword());
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
