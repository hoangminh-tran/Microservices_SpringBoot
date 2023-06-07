package com.microservices.EmployeeServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_firstName")
    private String firstName;

    @Column(name = "employee_lastName")
    private String lastName;

    @Column(name = "employee_email", nullable = false, unique = true)
    private String email;

    private String department_code;

    private String organization_code;
}
