package com.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.dto.DepartmentDto;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
public interface ApiClient {
	@GetMapping("/v1/department/getDepartmentByCode/{deptCode}")
	DepartmentDto getDepartment(@PathVariable String deptCode);
}
