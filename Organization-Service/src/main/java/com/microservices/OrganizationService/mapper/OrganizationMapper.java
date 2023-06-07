package com.microservices.OrganizationService.mapper;

import com.microservices.OrganizationService.dto.OrganizationDto;
import com.microservices.OrganizationService.entity.OrganizationEntity;

public class OrganizationMapper {
    public static OrganizationDto mapperedToOrganizationDto(OrganizationEntity organization)
    {
        return new OrganizationDto(organization.getOrganization_id(), organization.getName(), organization.getDescription(), organization.getCode(), organization.getCreatedDate());
    }

    public static OrganizationEntity mapperedToOrganization(OrganizationDto organization)
    {
        return new OrganizationEntity(organization.getOrganization_id(), organization.getName(), organization.getDescription(), organization.getCode(), organization.getCreatedDate());
    }
}
