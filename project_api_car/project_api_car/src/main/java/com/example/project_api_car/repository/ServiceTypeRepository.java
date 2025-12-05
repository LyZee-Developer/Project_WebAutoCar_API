package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_SERVICE_TYPE;

public interface  ServiceTypeRepository extends  JpaRepository<DB_SERVICE_TYPE, Long>,JpaSpecificationExecutor<DB_SERVICE_TYPE>{
}
