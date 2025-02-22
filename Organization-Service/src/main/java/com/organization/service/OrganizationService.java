package com.organization.service;

import com.organization.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto createOrganzation(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);
}