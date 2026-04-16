package com.vineet.department_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vineet.department_service.client.EmployeeClient;
import com.vineet.department_service.model.Department;
import com.vineet.department_service.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;

	public Department add(Department dept) {
		return departmentRepository.save(dept);
	}

	public List<Department> getAll() {
		return departmentRepository.findAll();
	}
	
	public Department getById(int id) {
		return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
	}

	public List<Department> getAllEmpByDept() {
		List<Department> depts = departmentRepository.findAll();
		depts.forEach(dept -> dept.setEmployees(employeeClient.getByDepartmentId(dept.getId()).getBody()));
		return depts;
	}

}
