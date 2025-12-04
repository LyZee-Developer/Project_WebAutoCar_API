package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.data_model.user.UserFilterDataModel;
import com.example.project_api_car.dto.UserDto;
import com.example.project_api_car.mapper.UserMapper;
import com.example.project_api_car.repository.UserRepository;
import com.example.project_api_car.service.UserService;
import com.example.project_api_car.specification.UserSpec;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserImplement implements  UserService {
    private final UserRepository  userRepository;
    @Override
    public List<UserDto> List(UserFilterDataModel filter){
        var list = userRepository.findAll(UserSpec.Search(filter.getSearch()).and(UserSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        return list.stream().map(s->UserMapper.MaptoDto(s,10L)).collect(Collectors.toList());
    }

    @Override
    public  UserDto  Create(UserDataModel model){
        var mapData = UserMapper.MaptoEntity(model);
        var data = userRepository.save(mapData);
        var result = UserMapper.MaptoDto(data,1L);
        return result;
    }

    @Override
    public UserDto Update(UserDataModel model){
        var data = userRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(model.getUsername());
        data.setGENDER(model.getGENDER());
        data.setPHONE(model.getPhone());
        data.setPHONE1(model.getPhone1());
        data.setUSER_CODE(model.getUserCode());
        data.setEMAIL(model.getEmail());
        data.setUPDATED_DATE(new Date());
        userRepository.save(data);
        var result = UserMapper.MaptoDto(data,1L);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        userRepository.deleteById(Id);
        return true;
    }
    @Override
    public Boolean CheckCode(String code,Long Id){
        userRepository.deleteById(Id);
        return true;
    }
    
}
