package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/home")
	public String home() {
		return "Hello";
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployee() {
		try {
			List<Employee> employeeList = empService.getEmployee();
			if (employeeList.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(employeeList));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		try {
			Employee employee = empService.getEmployeeById(id);
			if (employee == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(employee));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		try {
			Employee employe = empService.addEmployee(employee);
			return ResponseEntity.of(Optional.of(employe));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		try {
			this.empService.updateEmployee(employee);
			return ResponseEntity.ok().body(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		try {
			String message = empService.deleteEmployee(id);
			System.out.println(message);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
