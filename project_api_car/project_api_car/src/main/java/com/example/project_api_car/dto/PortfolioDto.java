package com.example.project_api_car.dto;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PortfolioDto extends IBaseDto{
    public Long  id;
    private List<ImageDto> images;
}
