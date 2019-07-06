package com.example.springbootzuulgatwayproxy.utilities;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageSaver {
    private final String path= "C:/Users/Ciurean Catalin/Desktop/licenta/";

    public String saveFingerprint(MultipartFile file, String userName){
        String fileName = file.getOriginalFilename();
        String newFileName = userName + fileName.substring(fileName.lastIndexOf('.'));
        Path filepath = Paths.get(path+"fingerPrints", newFileName);
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path+"fingerPrints/"+newFileName;

    }

    public String setCandidateFingerPrint( MultipartFile file){
        String fileName = file.getOriginalFilename();
        String newFileName = "candidate" + fileName.substring(fileName.lastIndexOf('.'));
        Path filepath = Paths.get(path+"candidate", newFileName);
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path +"candidate/candidate.tif";

    }
}
