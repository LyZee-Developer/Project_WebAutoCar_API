package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.data_model.section.SectionFilterDataModel;
import com.example.project_api_car.dto.SectionDto;

@Service
public interface SectionService {
    List<SectionDto> List(SectionFilterDataModel filter);
    SectionDto Create(SectionDataModel model);
    SectionDto Update(SectionDataModel model);
    Boolean Delete(Long Id);
}
