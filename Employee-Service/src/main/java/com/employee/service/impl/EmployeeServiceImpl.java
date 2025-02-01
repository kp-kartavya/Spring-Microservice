package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repo.EmployeeRepo;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo eRepo;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEntity(employeeDto);
		Employee emp = eRepo.save(employee);
		return EmployeeMapper.mapToDto(emp);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = eRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employeeId));
		return EmployeeMapper.mapToDto(employee);
	}

}
