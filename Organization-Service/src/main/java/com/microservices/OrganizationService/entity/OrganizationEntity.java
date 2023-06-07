package com.microservices.OrganizationService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "organization_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organization_id;

    private String name;

    private String description;

    @Column(nullable = false, unique = true)
    private String code;

    @Temporal(value = TemporalType.DATE)
    private LocalDate createdDate;
}
