package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_PORTFOLIO;

public interface  PortfolioRepository extends  JpaRepository<DB_PORTFOLIO, Long>,JpaSpecificationExecutor<DB_PORTFOLIO>{
}
