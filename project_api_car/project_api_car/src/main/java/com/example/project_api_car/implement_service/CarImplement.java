package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.data_model.car.CarFilterDataModel;
import com.example.project_api_car.dto.CarDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.CarMapper;
import com.example.project_api_car.repository.CarRepository;
import com.example.project_api_car.service.CarService;
import com.example.project_api_car.specification.CarSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CarImplement implements  CarService {
    private final CarRepository  carRepository;
    @Override
    public List<CarDto> List(CarFilterDataModel filter){
        var list = carRepository.findAll(CarSpec.Search(filter.getSearch()).and(CarSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
       
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getSTATUS().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->CarMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  CarDto  Create(CarDataModel model){
        var mapData = CarMapper.MaptoEntity(model);
        var data = carRepository.save(mapData);
        var result = CarMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public CarDto Update(CarDataModel model){
        var data = carRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setSTATUS(model.getStatus());
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        carRepository.save(data);
        var result = CarMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        carRepository.deleteById(Id);
        return true;
    }
    
}
