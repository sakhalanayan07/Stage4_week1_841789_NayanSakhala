package com.cognizant.springlearn.model;

import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.SpringRestApplication;


@Component
public class Employee {

	private int id;
	private String name;
	private double salary;
	private String type;
	private Date dateOfBirth;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);

	public Employee() {
		LOGGER.info("Inside Employee Constructor");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", type=" + type + ", dateOfBirth="
				+ dateOfBirth + "]";
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
