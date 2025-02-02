package com.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.DepartmentDto;
import com.department.service.DepartmentService;

@RestController
@RequestMapping("/v1/department/")
public class DepartmentController {
	@Autowired
	private DepartmentService dService;

	@PostMapping("save")
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto dept) {
		DepartmentDto d = dService.saveDepartment(dept);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}

	@GetMapping("getDepartmentByCode/{deptCode}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String deptCode) {
		DepartmentDto d = dService.getDepartmentByCode(deptCode);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
}
