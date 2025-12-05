package com.example.project_api_car.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class DB_CAR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  ID;
    @Column(length=100,name="NAME")
    private String NAME;
    @Column(length=100,name="NAME_EN")
    private String NAME_EN;
    @Column(nullable = false)
    private Boolean STATUS;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String CREATED_BY;
    @Column(name="CREATED_DATE",nullable = false )
    private Date CREATED_DATE;
    @Column(length=50,name="DB_CODE")
    private String DB_CODE;
     @Column(name="UPDATED_BY",nullable = true )
    private String UPDATED_BY;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date UPDATED_DATE;
}
