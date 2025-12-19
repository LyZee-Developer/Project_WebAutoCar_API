package com.example.project_api_car.data_model.block_content_detail;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BlockContentDetailFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
    private Long contentBlockId;
}
