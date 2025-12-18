package com.example.project_api_car.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DB_OWNER_INFO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(length=50,nullable=false)
    private String NAME;
    @Column(length=50,nullable=false)
    private String NAME_EN;
    @Column(length=15,nullable=false)
    private String PHONE;
    @Column(length=15,nullable=true)
    private String PHONE1;
    @Column(length=255)
    private String EMAIL;
    private String SUB_DESCRIPTION;
    private String SUB_DESCRIPTION_EN;
    @Column(length=1000)
    private String DESCRIPTION;
    @Column(length=1000)
    private String DESCRIPTION_EN;
    private String FACEBOOK_URL;
    private String IN_URL;
    private String INSTAGRAM_URL;
    private String YOUTUBE_URL;
    private String TELEGRAM_URL;
    private String WORKING_INFO;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String CREATED_BY;
    @Column(name="CREATED_DATE",nullable = false )
    private Date CREATED_DATE;
    @Column(length=50,name="DB_CODE",nullable = false)
    private String DB_CODE;
     @Column(name="UPDATED_BY",nullable = true )
    private String UPDATED_BY;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date UPDATED_DATE;

}
