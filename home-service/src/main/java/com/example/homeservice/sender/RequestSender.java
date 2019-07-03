package com.example.homeservice.sender;


import com.example.homeservice.entity.dto.HomeDataDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.Future;

@Component
public class RequestSender {
@Autowired
HomeDataDto homeDataDto;
    private static final String baseUrl = "http://192.168.137.252";

    public Future<String> asyncMethodWithReturnType(String state) {
        HttpHeaders headers = new HttpHeaders();

//        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.set("State", state);

        HttpEntity<String> request = new HttpEntity<String>("ciurean", headers);
        RestTemplate restTemplate = new RestTemplate();
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        restTemplate.getMessageConverters().add(0, stringHttpMessageConverter);
        restTemplate
                .exchange(baseUrl, HttpMethod.POST, request, String.class);
        return new AsyncResult<String>("ok");


    }

    public HomeDataDto getData(String userName) {

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>("ciurean");
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        restTemplate.getMessageConverters().add(0, stringHttpMessageConverter);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(baseUrl, HttpMethod.POST, request, String.class);
        String responseEntityBody = responseEntity.getBody();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(responseEntityBody);
            homeDataDto.setUserName(userName);
            homeDataDto.setTemperature(jsonObject.getInt("temperature"));
            homeDataDto.setHumidity(jsonObject.getInt("humidity"));
            homeDataDto.setHeatIndex(jsonObject.getInt("heatIndex"));
            return homeDataDto;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }
}
