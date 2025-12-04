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
public class DB_USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  ID;
    @Column(length=50,name="NAME")
    private String NAME;
    @Column(length=50,name="NAME_EN")
    private String NAME_EN;
    @Column(length=20,nullable=false)
    private String PHONE;
    @Column(length=20)
    private String PHONE1;
    @Column(length=100)
    private String EMAIL;
    private Boolean GENDER;
    @Column(length=20,nullable=false)
    private String USER_CODE;
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
