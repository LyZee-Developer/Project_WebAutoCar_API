package com.example.project_api_car.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.cfg.Environment;
import org.springframework.web.multipart.MultipartFile;

import com.example.project_api_car.config.PortReader;
import com.example.project_api_car.dto.UploadDto;
import com.example.project_api_car.helper.GlobalHelper;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UploadImageHandler {
    private PortReader portReader;
    private String FolderName;
    private Environment environment;
    public UploadImageHandler(String FolderName){
        this.FolderName = FolderName;
    }
    public  UploadDto Upload(MultipartFile file){
        try {
            var dto = new UploadDto();
            var folderPath=GlobalHelper.Path.upload+"\\" + this.FolderName;
            // Create folder if not exists
            Path uploadPath = Paths.get(folderPath);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Create storage path
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replace(" ", "_");
            Path filePath = uploadPath.resolve(fileName);
            System.out.println("->"+file);
            // Save file
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            dto.setFilename(fileName);
            dto.setType(file.getContentType());
            dto.setSize(file.getSize());
            return dto;

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

}
