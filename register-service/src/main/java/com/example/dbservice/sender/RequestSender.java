package com.example.dbservice.sender;

import com.example.dbservice.entity.dto.UserHomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Component
public class RequestSender {
    @Autowired
    private LoadBalancerClient loadBalancer;


    @Async
    public Future<String> asyncMethodWithReturnType(UserHomeDto userHomeDto) {


        ServiceInstance instances = loadBalancer.choose("home-service");
            System.out.println(instances.getUri());

            String baseUrl = instances.getUri().toString();
            HttpEntity<UserHomeDto> request = new HttpEntity<>(userHomeDto);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate
                    .exchange(baseUrl + "/test/home", HttpMethod.POST, request, UserHomeDto.class);
            return new AsyncResult<String>("hello world !!!!");



    }
}
