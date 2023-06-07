package com.microservices.EmployeeServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department_code;

    private String organization_code;
}
