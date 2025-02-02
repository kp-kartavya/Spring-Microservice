package com.department.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{
	Optional<Department> findByDeptCode(String deptCode);
}
