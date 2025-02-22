package com.organization.service.impl;

import org.springframework.stereotype.Service;

import com.organization.dto.OrganizationDto;
import com.organization.entity.Organization;
import com.organization.mapper.OrganizationMapper;
import com.organization.repo.OrganizationRepo;
import com.organization.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepo organizationRepo;

	@Override
	public OrganizationDto createOrganzation(OrganizationDto organizationDto) {

		Organization organization = OrganizationMapper.mapToEntity(organizationDto);

		Organization savedOrganization = organizationRepo.save(organization);

		return OrganizationMapper.mapToDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

		Organization organization = organizationRepo.findByOrganizationCode(organizationCode);

		return OrganizationMapper.mapToDto(organization);
	}

}