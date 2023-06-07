package com.microservices.OrganizationService.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
}
