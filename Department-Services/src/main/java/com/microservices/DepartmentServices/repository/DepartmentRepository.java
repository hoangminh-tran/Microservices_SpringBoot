package com.microservices.DepartmentServices.repository;


import com.microservices.DepartmentServices.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByCode(String code);
}
