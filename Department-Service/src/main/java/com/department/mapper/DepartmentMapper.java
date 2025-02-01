package com.department.mapper;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;

public class DepartmentMapper {
	public static DepartmentDto mapToDto(Department dept) {
		return new DepartmentDto(dept.getId(), dept.getDeptName(), dept.getDeptDesc(), dept.getDeptCode());
	}

	public static Department mapToEntity(DepartmentDto dept) {
		return new Department(dept.getId(), dept.getDeptName(), dept.getDeptDesc(), dept.getDeptCode());
	}
}
