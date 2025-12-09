package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.portfolio.PortfolioDataModel;
import com.example.project_api_car.data_model.portfolio.PortfolioFilterDataModel;
import com.example.project_api_car.dto.PortfolioDto;

@Service
public interface PortfolioService {
    List<PortfolioDto> List(PortfolioFilterDataModel filter);
    PortfolioDto Create(PortfolioDataModel model);
    Boolean Delete(Long Id);
    Boolean DeleteImage(Long imageId);
}
