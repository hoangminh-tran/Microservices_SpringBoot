package com.microservices.OrganizationService.controller;

import com.microservices.OrganizationService.dto.OrganizationDto;
import com.microservices.OrganizationService.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> createNewOrganization(@RequestBody OrganizationDto organizationDto)
    {
        return new ResponseEntity<>(organizationService.createNewOrganization(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("/getOrganizationByCode/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String code)
    {
        return new ResponseEntity<>(organizationService.getOrganizationByCode(code), HttpStatus.OK);
    }
}
