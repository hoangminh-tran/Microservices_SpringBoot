package com.microservices.EmployeeServices.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto {
    private Long employee_id;

    private String firstName;

    private String lastName;

    private String department_name;

    private String department_description;
}
