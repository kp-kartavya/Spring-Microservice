package com.organization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.OrganizationDto;
import com.organization.service.OrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	@PostMapping
	public ResponseEntity<OrganizationDto> createOrganzation(@RequestBody OrganizationDto organizationDto) {

		OrganizationDto organzation = organizationService.createOrganzation(organizationDto);

		return new ResponseEntity<OrganizationDto>(organzation, HttpStatus.CREATED);
	}

	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {

		OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

		return new ResponseEntity<OrganizationDto>(organizationDto, HttpStatus.OK);
	}

}