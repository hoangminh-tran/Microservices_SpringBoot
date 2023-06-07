package com.microservices.OrganizationService.service.impl;

import com.microservices.OrganizationService.dto.OrganizationDto;
import com.microservices.OrganizationService.entity.OrganizationEntity;
import com.microservices.OrganizationService.mapper.OrganizationMapper;
import com.microservices.OrganizationService.repository.OrganizationRepository;
import com.microservices.OrganizationService.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    @Override
    public OrganizationDto createNewOrganization(OrganizationDto organizationDto) {
        LOGGER.info("inside CreateNewOrganization Method");

        OrganizationEntity organization = OrganizationMapper.mapperedToOrganization(organizationDto);

        OrganizationEntity savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapperedToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        LOGGER.info("inside getOrganizationByCode Method");

        OrganizationEntity organization = organizationRepository.findOrganizationByCode(code);

        if(organization == null) return null;

        return OrganizationMapper.mapperedToOrganizationDto(organization);
    }
}
