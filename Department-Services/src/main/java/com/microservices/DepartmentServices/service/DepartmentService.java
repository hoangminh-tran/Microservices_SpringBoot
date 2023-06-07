package com.microservices.DepartmentServices.service;

import com.microservices.DepartmentServices.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createNewDepartment(DepartmentDto departmentDto);

    DepartmentDto findDepartmentByDepartmentCode(String code);

    DepartmentDto updateDepartmentInfo(DepartmentDto departmentDto);
}
