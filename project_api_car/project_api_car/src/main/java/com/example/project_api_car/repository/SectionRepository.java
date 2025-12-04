package com.example.project_api_car.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_SECTION;

public interface  SectionRepository extends  JpaRepository<DB_SECTION, Long>,JpaSpecificationExecutor<DB_SECTION>{
    Optional<DB_SECTION> findById(Long id);
}
