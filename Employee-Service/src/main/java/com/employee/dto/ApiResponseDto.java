package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
	private EmployeeDto empDto;
	private DepartmentDto deptDto;
	private OrganizationDto orgDto;
}
