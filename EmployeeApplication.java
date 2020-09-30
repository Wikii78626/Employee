package com.solelogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solelogic.entity.Employee;
import com.solelogic.service.AttendanceService;
import com.solelogic.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService empserv;
	@Autowired
	private AttendanceService attserv;
	// @Autowired
	// EmployeeSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee("Mustafa", "Peshawar", "Mechanical");
		empserv.addEmployeeToSystem(emp1);
		// empserv.addEmployeeToSystem("Waqar", "Lahore", "Civil");
		// empserv.addEmployeeToSystem("Wasim", "Karachi", "IT");
		// empserv.findEmployeeByName("Wasim");
		// empserv.deleteEmployeeById(3);
		/*
		 * attserv.checkIn("Waqar"); attserv.checkOut("Waqar"); LocalDate myObj =
		 * LocalDate.now(); myObj = myObj.minusDays(1);
		 * attserv.attendanceReportByDate("Waqar", myObj, LocalDate.now());
		 */
		// findById_EmployeePresent(1);
	}

	/*
	 * public void findById_EmployeePresent(int id) { Optional<Employee>
	 * employeeOptional = repository.findById(id); logger.info("{}",
	 * employeeOptional.isPresent());
	 * 
	 * }
	 * 
	 * public void findById_EmployeeNotPresent(int id) { Optional<Employee>
	 * employeeOptional = repository.findById(id); logger.info("{}",
	 * employeeOptional.isPresent());
	 * 
	 * }
	 */

}
