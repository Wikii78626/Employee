package com.solelogic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solelogic.entity.Employee;

@Repository
public interface EmployeeSpringDataRepository extends JpaRepository<Employee, Integer> {

	public Employee findEmployeeByDepartment(String department);

	public Employee findEmployeeByName(String name);

	public Employee findEmployeeByLocation(String location);

	public List<Employee> findAll();

	public Employee findById(int id);

	public Employee deleteById(int id);

}
