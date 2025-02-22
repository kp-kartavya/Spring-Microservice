package com.organization.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entity.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {

	Organization findByOrganizationCode(String organizationCode);
}