package com.microservices.EmployeeServices.service;

import com.microservices.EmployeeServices.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value= "ORGANIZATION-SERVICE", url = "http://localhost:8083/api/organizations/")
public interface FeignClient_Organization {
    @PostMapping("/save")
    OrganizationDto createNewOrganization(@RequestBody OrganizationDto organizationDto);

    @GetMapping("/getOrganizationByCode/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable("code") String code);
}
