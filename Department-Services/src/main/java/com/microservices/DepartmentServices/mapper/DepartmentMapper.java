package com.microservices.DepartmentServices.mapper;


import com.microservices.DepartmentServices.dto.DepartmentDto;
import com.microservices.DepartmentServices.entity.Department;

public class DepartmentMapper {
    public static Department mapperToDepartment(DepartmentDto dto)
    {
        return new Department(dto.getId(), dto.getName(), dto.getDescription(), dto.getCode());
    }

    public static DepartmentDto mapperToDepartmentDto(Department dto)
    {
        return new DepartmentDto(dto.getId(), dto.getName(), dto.getDescription(), dto.getCode());
    }
}
