package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repo.EmployeeRepo;
import com.employee.service.ApiClient;
import com.employee.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo eRepo;

//	@Autowired
//	private RestTemplate rT;

	@Autowired
	private WebClient wT;

//	@Autowired
//	ApiClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEntity(employeeDto);
		Employee emp = eRepo.save(employee);
		return EmployeeMapper.mapToDto(emp);
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		Employee employee = eRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employeeId));

//		ResponseEntity<DepartmentDto> res = rT.getForEntity(
//				"http://localhost:8080/v1/department/getDepartmentByCode/" + employee.getDeptCode(),
//				DepartmentDto.class);
//		DepartmentDto d = res.getBody();

		DepartmentDto d = wT.get()
				.uri("http://localhost:8080/v1/department/getDepartmentByCode/" + employee.getDeptCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();
//		DepartmentDto d = apiClient.getDepartment(employee.getDeptCode());

		ApiResponseDto api = new ApiResponseDto();
		api.setEmpDto(EmployeeMapper.mapToDto(employee));
		api.setDeptDto(d);
		return api;
	}

	public ApiResponseDto getDefaultDepartment(Long employeeId, Exception ex) {
		Employee employee = eRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employeeId));

		DepartmentDto d = new DepartmentDto(); 
		d.setDeptName("R&D Department");
		d.setDeptCode("RD001");
		d.setDeptDesc("Research & Development Department");

		ApiResponseDto api = new ApiResponseDto();
		api.setEmpDto(EmployeeMapper.mapToDto(employee));
		api.setDeptDto(d);
		return api;
	}

}
