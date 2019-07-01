package com.example.loginservice.service;//package com.techprimers.security.jwtsecurity.service;






import com.example.loginservice.entity.UserEntity;
import com.example.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean userAlreadyExists(String userName) {
        if(!userRepository.findByUsername(userName).isEmpty()) {
            return true;
        }
        else
            return false;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<String> getTemplates() {
      return userRepository.getTemplates();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity findByTemplate(String template) {
        UserEntity user = userRepository.findByTemplate(template);
        return user;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean verifyUser(UserEntity userEntity) {
        List<UserEntity> user = userRepository.findByUsernameAndPassword(userEntity.getUserName(),userEntity.getPassword());
        if (!user.isEmpty())
            return true;
        else
            return false;
    }
}
