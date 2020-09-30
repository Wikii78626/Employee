package com.solelogic.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solelogic.entity.Employee;
import com.solelogic.service.EmployeeService;

@Valid
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/employeeId/")
	public String employeeById(@RequestParam(value = "id") int id) {

		Employee emp = service.findById(id);
		return "Department of employee is " + emp.getDepartment();

	}

	@GetMapping("/employeeInfo")
	public String employeeByName(@RequestParam(value = "name") String name, @RequestParam(value = "id") int id) {

		System.out.println("Name received from browser: " + name);
		Employee emp = service.findEmployeeByName(name);
		if (null == emp) {
			return "No Employee With Such Name Is Found ";
		} else
			return "The Department of an employee is " + emp.getDepartment();
	}

	@GetMapping("/location/{location}")
	public String employeeLocation(@PathVariable String location) {
		Employee emp = service.findEmployeeByLocation(location);
		if (null == emp) {
			return "No Employee With Such Location Is Found ";
		} else
			return "The employee name of given location is " + emp.getName();
	}

	@GetMapping("/department/{department}")
	public String employeeDepartment(@PathVariable String department) {
		Employee emp = service.findEmployeeByDepartment(department);
		if (null == emp) {
			return "No Employee With Such Department Is Found ";
		} else
			return "The employee name of given Department is " + emp.getName();
	}

	@PostMapping("/add")
	public Employee addEmp(@Valid @RequestBody Employee emp) {
		service.addEmployeeToSystem(emp);
		return emp;

	}

	@GetMapping("/all")
	public List<Employee> retrieveAllEmp() {
		return service.allEmp();

	}

	@DeleteMapping("delete/{id}")
	public String empRemoved(@PathVariable int id) {
		Employee emp = service.findById(id);
		if (null == emp) {
			return "No Employee With Such Id Is Found ";
		} else {
			service.deleteById(id);
			return "The Employee has been deleted with name " + emp.getName();
		}
	}

	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee updatedemp) {
		return service.updateEmployee(updatedemp);

	}

}
