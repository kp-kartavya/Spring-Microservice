package com.organization.mapper;

import com.organization.dto.OrganizationDto;
import com.organization.entity.Organization;

public class OrganizationMapper {

	public static OrganizationDto mapToDto(Organization organization) {

		OrganizationDto organizationDto = new OrganizationDto(organization.getId(), organization.getOrganizationName(),
				organization.getOrganizationDescription(), organization.getOrganizationCode(),
				organization.getCreatedDate());

		return organizationDto;
	}

	public static Organization mapToEntity(OrganizationDto organizationDto) {

		Organization organization = new Organization(organizationDto.getId(), organizationDto.getOrganizationName(),
				organizationDto.getOrganizationDescription(), organizationDto.getOrganizationCode(),
				organizationDto.getCreatedDate());

		return organization;
	}
}