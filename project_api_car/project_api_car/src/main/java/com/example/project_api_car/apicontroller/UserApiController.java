package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.UserController;
import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.data_model.user.UserFilterDataModel;
import com.example.project_api_car.helper.UserHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class UserApiController {
    private final UserController userControllers;
    @PostMapping(UserHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody UserFilterDataModel filer){
        var result = userControllers.List(filer);
        return ResponseEntity.ok(result);
    }

    @PostMapping(UserHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody UserDataModel model){
        var result = userControllers.Create(model);
        return ResponseEntity.ok(result.getBody());
    }

    @PostMapping(UserHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody UserDataModel model){
        var result = userControllers.Update(model);
        return ResponseEntity.ok(result.getBody());
    }

    @GetMapping(UserHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = userControllers.Delete(Id);
        return ResponseEntity.ok(result.getBody());
    }
    @PostMapping(UserHelper.URL.CheckCode)
    public ResponseEntity<?> CheckCode(@RequestParam(value="Code") String Code,@RequestParam(value="Id") Long Id){
        var result = userControllers.CheckCode(Code,Id);
        return ResponseEntity.ok(result.getBody());
    }
}
