package com.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;
import com.department.exception.ResourceNotFoundException;
import com.department.mapper.DepartmentMapper;
import com.department.repo.DepartmentRepo;
import com.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepo dRepo;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto dept) {
		Department department = DepartmentMapper.mapToEntity(dept);
		Department d = dRepo.save(department);
		return DepartmentMapper.mapToDto(d);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String deptCode) {
		Department d = dRepo.findByDeptCode(deptCode)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Department Code", deptCode));
		;
//		Department dept = dRepo.findById(d.getId())
//				.orElseThrow(() -> new ResourceNotFoundException("Department", "Department Code", d.getId()));
		return DepartmentMapper.mapToDto(d);
	}

}
