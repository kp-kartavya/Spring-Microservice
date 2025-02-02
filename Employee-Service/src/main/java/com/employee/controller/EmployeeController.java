package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

    @PostMapping("save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
    	ApiResponseDto e = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
}
