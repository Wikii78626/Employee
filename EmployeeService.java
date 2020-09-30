package com.solelogic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solelogic.CustomException;
import com.solelogic.EmployeeNotFound;
import com.solelogic.entity.Employee;
import com.solelogic.repository.EmployeeSpringDataRepository;

@Transactional
@Service
public class EmployeeService {

	@Autowired
	private EmployeeSpringDataRepository repository;

	/**
	 * Entity will be saved through Spring Data Jpa.
	 * 
	 * @param name
	 * @param location
	 * @param department
	 */

	public void addEmployeeToSystem(Employee emp) {
		repository.save(emp);
	}

	/**
	 * it will check if the emp of such id exists.
	 * 
	 * @param id
	 */
	/*
	 * public Optional findById_EmployeePresent(int id) { Optional<Employee>
	 * employeeOptional = repository.findById(id);
	 * System.out.println(employeeOptional.isPresent()); return employeeOptional;
	 * 
	 * }
	 */

	public Employee findById(int id) {
		Employee emp = repository.findById(id);

		if (null == emp) {
			throw new CustomException(" id not found " + id, 1000);
		}
		return emp;
	}

	/**
	 * it will get the name and find the employee of such name if it exists.
	 * 
	 * @param name
	 * @return
	 */

	public Employee findEmployeeByName(String name) {
		Employee emp = repository.findEmployeeByName(name);
		if (null == emp) {
			System.out.println("Employee does not exist for id: " + name);
		} else {
			System.out.println("Found employee with the given id and its department is: " + emp.getDepartment());
		}

		return emp;
	}

	/**
	 * it will get the location and will find the employee of such location if it
	 * exists.
	 * 
	 * @param location
	 */

	public Employee findEmployeeByLocation(String location) {
		Employee emp = repository.findEmployeeByLocation(location);
		if (null == emp) {
			throw new EmployeeNotFound("Employee does not exist for location " + location, 10002);
		}
		return emp;
	}

	/**
	 * it will get the department and will find the employee of such department if
	 * it exists.
	 * 
	 * @param department
	 */
	public Employee findEmployeeByDepartment(String department) {
		Employee emp = repository.findEmployeeByDepartment(department);
		if (emp == null) {
			System.out.println("Employee does not exist for department : " + department);
		} else {
			System.out.println("Found employee with the given department and his name is: " + emp.getName());

		}
		return emp;
	}

	/**
	 * it will get the id of an employee and will delete it.
	 * 
	 * @param id
	 */
	public Employee deleteById(int id) {
		Employee emp = repository.deleteById(id);
		return emp;
	}

	public List<Employee> allEmp() {
		return repository.findAll();

	}

	public String updateEmployee(Employee emp) {
		Employee emp1 = repository.findById(emp.getId());
		if (null != emp1) {
			emp1.setName(emp.getName());
			emp1.setDepartment(emp.getDepartment());
			emp1.setLocation(emp.getLocation());
			return "Found and Updated";
		} else
			return "No Employee with such Id Found";
	}

}
