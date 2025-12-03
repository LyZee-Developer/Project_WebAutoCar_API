package com.example.project_api_car.implement_service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.dto.SectionDto;
import com.example.project_api_car.mapper.SectionMapper;
import com.example.project_api_car.repository.SectionRepository;
import com.example.project_api_car.service.SectionService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SectionImplement implements  SectionService {
    private SectionRepository  sectionRepository;
    // @Override
    // public List<SectionDto> List(){

    // }

    @Override
    public  SectionDto  Create(SectionDataModel model){
        var mapData = SectionMapper.MaptoEntity(model);
        var data = sectionRepository.save(mapData);
        var result = SectionMapper.MaptoDto(data);
        return result;
    }

    @Override
    public SectionDto Update(SectionDataModel model){
        var data = sectionRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(model.getUsername());
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(model.getDatabase());
        sectionRepository.save(data);
        var result = SectionMapper.MaptoDto(data);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        return true;
    }
    
}
