package com.example.springbootzuulgatwayproxy.controller;


import com.example.springbootzuulgatwayproxy.dto.UserDto;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final String path= "C:/Users/catac/Desktop/licenta/";
    private final String loginUrl = "http://localhost:8442/user/";
    private final String signUpUrl = "http://localhost:8441/user/signUp";

     @Autowired
    private LoadBalancerClient loadBalancer;


    @RequestMapping(value = "/signUp" ,method = RequestMethod.POST, consumes = "multipart/form-data")
   public ResponseEntity<String> signUp(

            @RequestParam(value="file",required = false) MultipartFile file,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("userName") String userName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role ) {

        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setUserName(userName);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setRole(role);
        System.out.println(userDto.getFingerprintPath());
        System.out.println(userDto.getUserName());
        if (file != null) {
            saveFingerprint(file, userName);
            userDto.setFingerprintPath(path+"fingerPrints/"+userName+".tif");
        }
        System.out.println(userDto.getFingerprintPath());
        ServiceInstance instances = loadBalancer.choose("register-service");
        System.out.println(instances.getUri());

        String baseUrl = instances.getUri().toString();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UserDto> request = new HttpEntity<>(userDto);
        try {
            return  restTemplate
                    .exchange(baseUrl+"/user/signUp", HttpMethod.POST, request, String.class);
        } catch(HttpClientErrorException e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }


//        ResponseEntity<String> responseEntity = restTemplate
//                .exchange(baseUrl+"/user/signUp", HttpMethod.POST, request, String.class);
//        String response = responseEntity.getBody();
//        String jwt = (response.subSequence(1,response.length()-1)).toString();
//        return new ResponseEntity<>(JSONObject.quote("ok"),HttpStatus.OK);
    }



    @RequestMapping(value = "/login" ,method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<String> login(  @RequestParam(value="file",required = false) MultipartFile file,
                                          @RequestParam("userName") String userName,
                                          @RequestParam("password") String password,
                                          @RequestParam("role") String role
                                          ){
            UserDto userDto = new UserDto();
            userDto.setUserName(userName);
            userDto.setPassword(password);
            userDto.setRole(role);
//
//
        System.out.println(userName);
        if (file != null) {
            userDto.setFingerprintPath(path+"candidate.tif");
            setCandidateFingerPrint(file);
        }
            ServiceInstance instances = loadBalancer.choose("login-service");


            String baseUrl = instances.getUri().toString();

            baseUrl = baseUrl + "/user/login";
            HttpEntity<UserDto> request = new HttpEntity<>(userDto);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(baseUrl, HttpMethod.POST, request, String.class);
            String response = responseEntity.getBody();
            String jwt = (response.subSequence(1,response.length()-1)).toString();
            return new ResponseEntity<>(JSONObject.quote(jwt),HttpStatus.OK);
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



