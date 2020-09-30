package com.solelogic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Employee Entity
 * 
 * @author Dell
 *
 */
@Valid
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Size(min = 5, message = "Name should be of maximum 15 letters")
	private String name;
	@NotNull
	@Size(min = 5, message = "location should have atleast 5 characters")
	private String location;

	@JsonProperty("dept")
	private String department;

	public Employee() {
	}

	public Employee(String name, String location, String department) {
		super();
		this.name = name;
		this.location = location;
		this.department = department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", department=" + department + "]";
	}

}
