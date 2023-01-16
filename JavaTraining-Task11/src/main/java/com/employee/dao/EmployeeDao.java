package com.employee.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.employee.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	@Query("SELECT COUNT(u) FROM Employee u")
	public int  countEmployee();

}
