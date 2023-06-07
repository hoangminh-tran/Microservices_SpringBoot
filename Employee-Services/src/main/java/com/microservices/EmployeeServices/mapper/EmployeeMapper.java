package com.microservices.EmployeeServices.mapper;


import com.microservices.EmployeeServices.dto.EmployeeDto;
import com.microservices.EmployeeServices.entity.Employee;

public class EmployeeMapper {
    public static Employee mapperToEmployee(EmployeeDto dto)
    {
        return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getDepartment_code(), dto.getOrganization_code());
    }

    public static EmployeeDto mapperToEmployeeDto(Employee dto)
    {
        return new EmployeeDto(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getDepartment_code(), dto.getOrganization_code());
    }
}

