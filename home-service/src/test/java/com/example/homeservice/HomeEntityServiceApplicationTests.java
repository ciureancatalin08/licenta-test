package com.example.homeservice;

import com.example.homeservice.controller.HomeController;
import com.example.homeservice.entity.HomeEntity;
import com.example.homeservice.entity.dto.HomeDataDto;
import com.example.homeservice.entity.dto.StateDto;
import com.example.homeservice.facade.HomeFacade;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class HomeEntityServiceApplicationTests {
    @Autowired
    HomeController homeController;
    @Autowired
    HomeFacade homeFacade;
   static String BASE_URL="http://localhost:8086/home/fans";
    private static final String STATE_ON = "ON";
    static String NAME = "cataciurean";
    @Test
    public void contextLoads() {
    }

    @Test
    public void getData_whenUserInfoIsRetrieved_then200IsReceived()
            throws ClientProtocolException, IOException {

        String name = "cataciurean";
        HttpUriRequest request = new HttpGet("http://localhost:8086/home/data?userName=" + name);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void setLights_whenUserInfoIsRetrieved_thenLights_200isReceived()
            throws ClientProtocolException, IOException {
        StateDto stateDto = new StateDto();
//        stateDto.setState(S);
        stateDto.setUserName("cataciurean");
        String baseUrl = "http://localhost:8086/home/lights";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StateDto> request = new HttpEntity<StateDto>(stateDto);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(baseUrl, HttpMethod.POST, request, String.class);
        assertThat(
                responseEntity.getStatusCode(),
                equalTo(org.springframework.http.HttpStatus.OK));
    }

    @Test
    public void setFans_whenUserInfoIsRetrieved_thenFans_200isReceived()
            throws ClientProtocolException, IOException {
        StateDto stateDto = new StateDto();
        stateDto.setState(STATE_ON);
        stateDto.setUserName(NAME);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StateDto> request = new HttpEntity<StateDto>(stateDto);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(BASE_URL, HttpMethod.POST, request, String.class);
        assertThat(
                responseEntity.getStatusCode(),
                equalTo(org.springframework.http.HttpStatus.OK));
    }

    @Test
    public void setAlarms_whenUserInfoIsRetrieved_thenAlarms_200isReceived()
            throws ClientProtocolException, IOException {
        StateDto stateDto = new StateDto();
        stateDto.setState("ON");
        stateDto.setUserName("cataciurean");
        String baseUrl = "http://localhost:8086/home/alarms";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StateDto> request = new HttpEntity<StateDto>(stateDto);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(baseUrl, HttpMethod.POST, request, String.class);
        assertThat(
                responseEntity.getStatusCode(),
                equalTo(org.springframework.http.HttpStatus.OK));
    }

    @Test
    @Transactional
    public void getData_whenUserInfoIsRetrieved_then_dataIsReceived()
            throws ClientProtocolException, IOException {
        String userName = "cataciurean";
        homeFacade.getData(userName);
//        Assert.assertNotNull(homeDataDto);
    }
    @Test
    public void setFans_whenUserInfoIsRetrieved_then_fansUpdated()
            throws ClientProtocolException, IOException {

        StateDto stateDto = new StateDto();
        stateDto.setState("ON");
        stateDto.setUserName("cataciurean");
        homeController.lightsController(stateDto);
//        Assert.assertNotNull(homeDataDto);
    }
}
