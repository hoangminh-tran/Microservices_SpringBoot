package com.microservices.EmployeeServices.service;

import com.microservices.EmployeeServices.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080/api/department")
public interface FeignClient_Department {
    @GetMapping("/findDepartmentByCode/{code}")
    DepartmentDto findDepartmentByDepartmentCode(@PathVariable("code") String code);

    @PutMapping("/updateDepartmentInfo")
    DepartmentDto updateDepartmentInfo(@RequestBody DepartmentDto dto);
}
