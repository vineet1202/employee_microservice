package com.vineet.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vineet.employee_service.model.Employee;
import com.vineet.employee_service.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("add")
	public ResponseEntity<Employee> add(@RequestBody Employee emp){
		return new ResponseEntity<>(employeeService.add(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Employee>> getAll(){
		return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getAll(@PathVariable int id){
		return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("department/{deptId}")
	public ResponseEntity<List<Employee>> getByDepartmentId(@PathVariable int deptId){
		return new ResponseEntity<>(employeeService.getByDepartmentId(deptId), HttpStatus.OK);
	}
	
	
}
