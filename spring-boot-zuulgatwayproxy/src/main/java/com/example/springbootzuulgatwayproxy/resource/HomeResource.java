package com.example.springbootzuulgatwayproxy.resource;

import com.example.springbootzuulgatwayproxy.dto.StateDto;
import com.example.springbootzuulgatwayproxy.facade.GatewayFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/test")
public class HomeResource {
    @Autowired
    GatewayFacade gatewayFacade;
    @GetMapping(value = "/home/data")
    public String getData(@RequestParam String userName
    ) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return gatewayFacade.getData(userName);
    }
    @PostMapping(value = "/home/lights")
    public String setLights(@RequestBody StateDto stateDto
    ) {
        return gatewayFacade.setLights(stateDto);
    }
    @PostMapping(value = "/home/fans")
    public String setFans(@RequestBody StateDto stateDto
    ) {
        return gatewayFacade.setFans(stateDto);
    }

    @PostMapping(value = "/home/alarms")
    public String setAlarms(@RequestBody StateDto stateDto
    ) {
        return gatewayFacade.setAlarms(stateDto);
    }
}
