package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.SpringRestApplication;

@Component
public class Department {

	private int id;
	
	private String name;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);

	public Department() {
		LOGGER.info("Inside Department Constructor");
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
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

}
