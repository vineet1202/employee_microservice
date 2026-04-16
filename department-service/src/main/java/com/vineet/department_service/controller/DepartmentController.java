package com.vineet.department_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vineet.department_service.model.Department;
import com.vineet.department_service.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("add")
	public ResponseEntity<Department> add(@RequestBody Department dept){
		return new ResponseEntity<>(departmentService.add(dept), HttpStatus.CREATED);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Department>> getAll(){
		return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getById(@PathVariable int id){
		return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("all-deptemps")
	public ResponseEntity<List<Department>> getAllEmpByDept(){
		return new ResponseEntity<>(departmentService.getAllEmpByDept(), HttpStatus.OK);
	}
	
	

}
