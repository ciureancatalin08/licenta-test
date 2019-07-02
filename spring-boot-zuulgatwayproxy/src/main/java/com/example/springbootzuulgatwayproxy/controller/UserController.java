package com.example.springbootzuulgatwayproxy.controller;

import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/user")

public class UserController {

    private final String path= "C:/Users/Ciurean Catalin/Desktop/licenta/";

    @Autowired
    private RegisterClient registerClient;

    @Autowired
    private LoginClient loginClient;

    UserDto userDto;

//    @PostMapping (value = "/register",consumes = "multipart/form-data")
//    public String registerUser(
//            @RequestParam(value="file", required = false) MultipartFile file,
//            @RequestParam("firstName") String firstName,
//            @RequestParam("lastName") String lastName,
//            @RequestParam("userName") String userName,
//            @RequestParam("email") String email,
//            @RequestParam("password") String password,
//            @RequestParam("role") String role ) {
//        userDto = new UserDto();
//        userDto.setUserName(userName);
//        userDto.setFirstName(firstName);
//        userDto.setLastName(lastName);
//        userDto.setEmail(email);
//        userDto.setPassword(password);
//        userDto.setRole(role);
//        if (file != null) {
//            saveFingerprint(file, userName);
//            userDto.setFingerprintPath(path+"fingerPrints/"+userName+".tif");
//        }
//    return registerClient.register(userDto);
//    }
  @PostMapping (value = "/register")
    public String registerUser(
            @RequestParam(value="file", required = false) MultipartFile file,

            @RequestParam("userName") String userName,
            @RequestParam("password") String password)
             {
        userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setFirstName("ciurean");
        userDto.setLastName("abcd");
        userDto.setEmail("abcd");
        userDto.setPassword(password);
        userDto.setRole("admin");
//        if (file != null) {
//            saveFingerprint(file, userName);
//            userDto.setFingerprintPath(path+"fingerPrints/"+userName+".tif");
//        }
    return registerClient.register(userDto);
    }



    @PostMapping (value = "/login")
    public String loginUser( @RequestParam("userName") String userName,
                             @RequestParam("password") String password
                            ){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
//        if (file != null) {
//            userDto.setFingerprintPath(path+"candidate/candidate.tif");
//            setCandidateFingerPrint(file);
//        }
    return loginClient.login(userDto);
    }





    public void saveFingerprint( MultipartFile file,String userName){
        String fileName = file.getOriginalFilename();
        String newFileName = userName + fileName.substring(fileName.lastIndexOf('.'));
        Path filepath = Paths.get(path+"fingerPrints", newFileName);
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setCandidateFingerPrint( MultipartFile file){
        String fileName = file.getOriginalFilename();
        String newFileName = "candidate" + fileName.substring(fileName.lastIndexOf('.'));
        Path filepath = Paths.get(path+"candidate", newFileName);
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
