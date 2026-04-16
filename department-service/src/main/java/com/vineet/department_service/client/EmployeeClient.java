package com.vineet.department_service.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.vineet.department_service.model.Employee;


@HttpExchange
public interface EmployeeClient {
	//declare method to call
	
	@GetExchange("employee/department/{deptId}")
	public ResponseEntity<List<Employee>> getByDepartmentId(@PathVariable int deptId);
}
