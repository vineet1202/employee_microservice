package com.vineet.employee_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vineet.employee_service.model.Employee;
import com.vineet.employee_service.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee add(Employee emp) {
		return employeeRepository.save(emp);
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee getById(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
	}

	public List<Employee> getByDepartmentId(int deptId) {
		return employeeRepository.findByDepartmentId(deptId).orElseThrow(() -> new RuntimeException("Department Not Found"));
	}

}
