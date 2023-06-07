package com.microservices.EmployeeServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPI {
    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
    private OrganizationDto organizationDto;
}
