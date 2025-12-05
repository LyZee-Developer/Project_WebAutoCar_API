package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.ServiceTypeController;
import com.example.project_api_car.data_model.service_type.ServiceTypeDataModel;
import com.example.project_api_car.data_model.service_type.ServiceTypeFilterDataModel;
import com.example.project_api_car.helper.ServiceTypeHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class ServiceTypeApiController {
    private final ServiceTypeController serviceTypeController;
    
    @PostMapping(ServiceTypeHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody ServiceTypeFilterDataModel filter){
        ResponseEntity<?> result = serviceTypeController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(ServiceTypeHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody ServiceTypeDataModel model){
        ResponseEntity<?> result = serviceTypeController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(ServiceTypeHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody ServiceTypeDataModel model){
        ResponseEntity<?> result = serviceTypeController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(ServiceTypeHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = serviceTypeController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
}
