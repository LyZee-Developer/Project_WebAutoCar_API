package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.data_model.user.UserFilterDataModel;
import com.example.project_api_car.helper.SectionHelper;
import com.example.project_api_car.helper.UserHelper;
import com.example.project_api_car.implement_service.UserImplement;
import com.example.project_api_car.repository.UserRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserController {
    private final UserImplement userImplement;
    private final UserRepository userRepository;

    public ResponseEntity<?> List(UserFilterDataModel filter) {
        try {
            var result = userImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(UserDataModel model) {
        try {
            var result = userImplement.Create(model);
            if (model.getUserCode().isEmpty())
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field usercode is required!"),
                        HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(UserDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            if (model.getUserCode().isEmpty()){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field usercode is required!"),
                    HttpStatus.BAD_REQUEST);
            }
            var isExisted = userRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.BAD_REQUEST);
            var result = userImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = userRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(SectionHelper.Message.NotFound, HttpStatus.BAD_REQUEST);
        }
        var result = userImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> CheckCode(String Code, Long Id) {
        var codes = userRepository.findAll();
        // if(!codes.isPresent()) return new ResponseEntity<>(false,HttpStatus.OK);
        var isExisted = false;
        // if(Id > 0) isExisted =
        // codes.get().stream().filter(s->!s.getID().equals(Id)).count() != 0;
        return ResponseEntity.ok(isExisted);
    }
}
