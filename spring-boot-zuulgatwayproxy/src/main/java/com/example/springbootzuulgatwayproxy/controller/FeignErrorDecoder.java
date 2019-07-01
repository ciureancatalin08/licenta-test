package com.example.springbootzuulgatwayproxy.controller;

import com.google.common.base.Charsets;
import feign.Response;
import feign.codec.ErrorDecoder;

import io.micrometer.core.instrument.util.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@Component
public class FeignErrorDecoder implements ErrorDecoder {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Exception decode(String methodKey, Response response) {


        switch (response.status()){
            case 403:
                try {
                    JSONObject res = new JSONObject( IOUtils.toString(response.body().asInputStream(), Charsets.UTF_8));
                    String message = res.getString("message");
                    String parsedMessage[] = message.split(":");
                    System.out.println(parsedMessage[1]);

                return new ResponseStatusException(HttpStatus.valueOf(response.status()), parsedMessage[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 404:
            {
                logger.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status() + ", methodKey = " + methodKey);
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.body().toString());
            }
            default:
                return new ResponseStatusException(HttpStatus.valueOf(response.status()));
        }
    }

}