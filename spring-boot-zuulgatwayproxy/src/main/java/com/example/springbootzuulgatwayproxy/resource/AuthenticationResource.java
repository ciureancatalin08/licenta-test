package com.example.springbootzuulgatwayproxy.resource;

import com.example.springbootzuulgatwayproxy.dto.UserDto;
import com.example.springbootzuulgatwayproxy.facade.GatewayFacade;
import com.example.springbootzuulgatwayproxy.utilities.ImageSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationResource {
    UserDto userDto;
    @Autowired
    ImageSaver imageSaver;
    @Autowired
    GatewayFacade gatewayFacade;
    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public String registerUser(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("userName") String userName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role) {
        userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setRole(role);
        if (file != null) {
            userDto.setFingerprintPath(imageSaver.saveFingerprint(file, userName));
            System.out.println(userDto.getFingerprintPath());
        }
        return gatewayFacade.registerUser(userDto);
    }


    @PostMapping (value = "/login",consumes = "multipart/form-data")
    public String loginUser( @RequestParam("userName") String userName,
                             @RequestParam("password") String password,
                             @RequestParam(value="file", required = false) MultipartFile file
    ){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
        if (file != null) {
            userDto.setFingerprintPath( imageSaver.setCandidateFingerPrint(file));
        }
        return gatewayFacade.loginUser(userDto);
    }
}
