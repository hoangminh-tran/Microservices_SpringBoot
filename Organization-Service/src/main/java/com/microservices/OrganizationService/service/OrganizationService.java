package com.microservices.OrganizationService.service;

import com.microservices.OrganizationService.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto createNewOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String code);
}
