package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_IMAGE;

public interface  ImageRepository extends  JpaRepository<DB_IMAGE, Long>,JpaSpecificationExecutor<DB_IMAGE>{
}
