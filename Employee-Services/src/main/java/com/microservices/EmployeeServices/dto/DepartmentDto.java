package com.microservices.EmployeeServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;

    private String name;

    private String description;

    private String code;

    public DepartmentDto(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }
}
