package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project_api_car.service.FileUploadService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class TestingUploadImage {
    
    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        var result = fileUploadService.uploadFile(file);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> Delete(@RequestParam(value="filename") String filename) {
        var result = fileUploadService.DeleteImage(filename);
        return ResponseEntity.ok(result);
    }
}
