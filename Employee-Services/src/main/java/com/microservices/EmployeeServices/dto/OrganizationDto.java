package com.microservices.EmployeeServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long organization_id;

    private String name;

    private String description;

    private String code;

    private LocalDate createdDate;

    public OrganizationDto(String name, String description, String code, LocalDate createdDate) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.createdDate = createdDate;
    }
}
