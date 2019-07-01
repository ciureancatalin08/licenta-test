package com.example.loginservice.controller.fingerprint;

import com.example.loginservice.entity.UserEntity;
import com.example.loginservice.service.UserService;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class FingerPrintResource {

    public String createTemplate(String path) {
        Path filepath = Paths.get(path);
        String fingerTemplate = null;
        if (path != null) {
            try {
                byte[] finger = Files.readAllBytes(filepath);
                FingerprintTemplate template = new FingerprintTemplate()
                        .dpi(500)
                        .create(finger);
                fingerTemplate = template.serialize();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fingerTemplate;

        } else {
            return null;
        }
    }

    @Autowired
    private UserService userService;
//    public String setFingerprint(String path) {
//        Path filepath = Paths.get(path);
//        String fingerTemplate = null;
//
//        try {
//            byte[] finger = Files.readAllBytes(filepath);
//            FingerprintTemplate template = new FingerprintTemplate()
//                    .dpi(500)
//                    .create(finger);
//            fingerTemplate = template.serialize();
//            System.out.println(fingerTemplate);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return fingerTemplate;
//
//    }

    public UserEntity verifyFingerprint(String fingerPrintTemplate) {
        String goodTemplate = "";
        boolean ok = false;
        double high = 0;
        double threshold = 40;

        ArrayList<String> templates = userService.getTemplates();
        ArrayList<FingerprintTemplate> temp = new ArrayList<FingerprintTemplate>();
        for (String template : templates) {
            if (template != null) {
                temp.add(new FingerprintTemplate().deserialize(template));
            }

        }

        FingerprintMatcher matcher = new FingerprintMatcher()
                .index(new FingerprintTemplate().deserialize(fingerPrintTemplate));

        FingerprintTemplate matchedTemplate = null;
        for (FingerprintTemplate template : temp) {
            double score = matcher.match(template);
            if (score > high) {
                high = score;
                matchedTemplate = template;
                System.out.println(score);
            }
        }
        if (high >= threshold) {
            goodTemplate = matchedTemplate.serialize();
            ok = true;
        }

        if (ok) {
            return userService.findByTemplate(goodTemplate);
        } else
            return null;
    }

}