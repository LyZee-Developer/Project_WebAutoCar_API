package com.example.project_api_car.entity;

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
public class DB_IMAGE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  ID;
     @Column(nullable=false)
    private Long REF_ID;
     @Column(nullable=false)
    private String TYPE;
     @Column(nullable=false)
    private String PATH_IMG;
    private String HOST_IMG;
    @Column(nullable=false)
    private String TYPE_IMG;
     @Column(nullable=false)
    private String SIZE_IMG;
     @Column(nullable=false)
    private String NAME_IMG;

}
