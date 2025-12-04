package com.example.project_api_car.data_model;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class IBaseFilterDataModel {
    protected Long Id;
    protected Long Page;
    protected Long Record;
    protected String Database;
    protected String Search;
    protected String OrderBy;
    protected String OrderDir;
}
