package com.solelogic.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.solelogic.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Employee findById(int Id) {
		return entityManager.find(Employee.class, Id);
	}

	public Employee findByName(String empName) {

		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE name = :name",
				Employee.class);
		query.setParameter("name", empName);
		Employee emp = null;
		try {
			emp = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("One Result Should Be there");
		}
		return emp;
	}

	public Employee findByLocation(String empLocation) {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE location = :location",
				Employee.class);
		query.setParameter("location", empLocation);
		Employee emp = null;
		try {
			emp = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("One Result Should Be there");
		}
		return emp;

	}

	public Employee findByDepartment(String empDepartment) {
		TypedQuery<Employee> query = entityManager
				.createQuery("SELECT e FROM Employee e WHERE department = :department", Employee.class);
		query.setParameter("department", empDepartment);
		Employee emp = null;
		try {
			emp = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("One Result Should Be there");
		}
		return emp;

	}

	public void saveEntity(Employee emp) {
		entityManager.persist(emp);
	}

	public Employee update(Employee emp) {
		return entityManager.merge(emp);
	}

	public void deleteEmployee(int empid) {
		Employee emp = entityManager.find(Employee.class, empid);

		if (null == emp) {
			System.out.println("Employee does not exist in database with ID: " + empid);
		} else {
			System.out.println("Employee exists and his name is " + emp.getName());
			entityManager.remove(emp);
			System.out.println("Employee deleted from DB.");
		}
	}
}
