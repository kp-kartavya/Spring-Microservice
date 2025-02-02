package com.employee.service;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.EmployeeDto;

public interface EmployeeService {
	 EmployeeDto saveEmployee(EmployeeDto employeeDto);
	 ApiResponseDto getEmployeeById(Long employeeId);
}
