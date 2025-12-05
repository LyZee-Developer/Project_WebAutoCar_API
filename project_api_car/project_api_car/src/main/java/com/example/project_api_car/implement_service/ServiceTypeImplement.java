package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.service_type.ServiceTypeDataModel;
import com.example.project_api_car.data_model.service_type.ServiceTypeFilterDataModel;
import com.example.project_api_car.dto.ServiceTypeDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.ServiceTypeMapper;
import com.example.project_api_car.repository.ServiceTypeRepository;
import com.example.project_api_car.service.ServiceTypeService;
import com.example.project_api_car.specification.ServiceTypeSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceTypeImplement implements  ServiceTypeService {
    private final ServiceTypeRepository  serviceTypeRepository;
    @Override
    public List<ServiceTypeDto> List(ServiceTypeFilterDataModel filter){
        var list = serviceTypeRepository.findAll(ServiceTypeSpec.Search(filter.getSearch()).and(ServiceTypeSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
      
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
        return list.stream().map(s->ServiceTypeMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  ServiceTypeDto  Create(ServiceTypeDataModel model){
        var mapData = ServiceTypeMapper.MaptoEntity(model);
        var data = serviceTypeRepository.save(mapData);
        var result = ServiceTypeMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public ServiceTypeDto Update(ServiceTypeDataModel model){
        var data = serviceTypeRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setSTATUS(model.getStatus());
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        serviceTypeRepository.save(data);
        var result = ServiceTypeMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        serviceTypeRepository.deleteById(Id);
        return true;
    }
    
}
