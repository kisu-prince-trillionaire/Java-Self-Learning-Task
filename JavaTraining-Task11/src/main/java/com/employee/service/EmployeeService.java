package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public Employee getEmployeeById(int id);

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public String deleteEmployee(int id);
}
