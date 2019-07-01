package com.example.dbservice.repository;//package com.techprimers.security.jwtsecurity.repository;


import com.example.dbservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface RegisterRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.userName= :username")
    List<UserEntity> findByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.userName= :username AND u.password= :password")
    List<UserEntity> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u.fingerPrintTemplate FROM UserEntity u ")
    ArrayList<String> getTemplates();

    @Query("SELECT u FROM UserEntity u WHERE u.fingerPrintTemplate= :fingerTemplate")
    UserEntity findByTemplate(@Param("fingerTemplate") String fingerTemplate);
}
////
////    @Query("SELECT u FROM User u WHERE u.token= :token")
////    List<User> verifyToken(@Param("token") String token);
////
////    @Modifying
////    @Query("UPDATE User Set token=:token Where username =:username")
////           void setToken(@Param("username") String username, @Param("token") String token);
//}
