package com.example.project_api_car.service;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.dto.SectionDto;

@Service
public interface SectionService {
    // List<SectionDto> List();
    SectionDto Create(SectionDataModel model);
    SectionDto Update(SectionDataModel model);
    Boolean Delete(Long Id);
}
