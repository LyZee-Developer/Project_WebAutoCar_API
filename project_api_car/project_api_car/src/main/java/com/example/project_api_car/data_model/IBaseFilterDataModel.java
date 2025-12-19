package com.example.project_api_car.data_model;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class IBaseFilterDataModel {
    protected Long id;
    protected Long page;
    protected Long record;
    protected String database;
    protected String search;
    protected String orderBy;
    protected String orderDir;
}
