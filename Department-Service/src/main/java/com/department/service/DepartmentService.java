package com.department.service;

import com.department.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto dept);
	DepartmentDto getDepartmentByCode(String deptCode);
}
