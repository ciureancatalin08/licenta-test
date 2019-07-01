package com.example.dbservice.service;//package com.techprimers.security.jwtsecurity.service;





import com.example.dbservice.entity.UserEntity;
import com.example.dbservice.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity saveUser(UserEntity userEntity) {
        return registerRepository.save(userEntity);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getUser(UserEntity userEntity) {
        return registerRepository.findByUsername(userEntity.getUserName());
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean userAlreadyExists(String userName) {
        if(registerRepository.findByUsername(userName)!=null) {
            return true;
        }
        else
            return false;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<String> getTemplates() {
      return registerRepository.getTemplates();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity findByTemplate(String template) {
        UserEntity user = registerRepository.findByTemplate(template);
        return user;
    }


}
