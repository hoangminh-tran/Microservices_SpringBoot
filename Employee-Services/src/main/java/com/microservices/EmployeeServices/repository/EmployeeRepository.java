package com.microservices.EmployeeServices.repository;

import com.microservices.EmployeeServices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getEmployeeById(Long id);
}
