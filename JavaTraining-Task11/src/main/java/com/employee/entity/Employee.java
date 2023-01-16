package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private int age;
	private long salary;
	private String jobTitle;
	private String gender;

	public Employee() {
	
	}

	public Employee(int id, String name, int age, long salary, String jobTitle, String gender) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.jobTitle = jobTitle;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", jobTitle="
				+ jobTitle + ", gender=" + gender + "]";
	}
}
