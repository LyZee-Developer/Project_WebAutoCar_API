package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.data_model.section.SectionFilterDataModel;
import com.example.project_api_car.dto.SectionDto;
import com.example.project_api_car.mapper.SectionMapper;
import com.example.project_api_car.repository.SectionRepository;
import com.example.project_api_car.service.SectionService;
import com.example.project_api_car.specification.SectionSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SectionImplement implements  SectionService {
    private final SectionRepository  sectionRepository;
    @Override
    public List<SectionDto> List(SectionFilterDataModel filter){
        var list = sectionRepository.findAll(SectionSpec.Search(filter.getSearch()).and(SectionSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        return list.stream().map(s->SectionMapper.MaptoDto(s)).collect(Collectors.toList());
    }

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
        sectionRepository.deleteById(Id);
        return true;
    }
    
}
