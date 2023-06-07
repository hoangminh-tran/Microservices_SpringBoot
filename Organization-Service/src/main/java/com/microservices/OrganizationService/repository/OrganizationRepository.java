package com.microservices.OrganizationService.repository;

import com.microservices.OrganizationService.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
    OrganizationEntity findOrganizationByCode(String code);
}
