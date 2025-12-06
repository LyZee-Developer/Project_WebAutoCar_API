package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_OWNER_INFO;

public interface  OwnerInfoRepository extends  JpaRepository<DB_OWNER_INFO, Long>,JpaSpecificationExecutor<DB_OWNER_INFO>{
}
