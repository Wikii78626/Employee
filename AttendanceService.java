package com.solelogic.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solelogic.entity.Attendance;
import com.solelogic.entity.Employee;
import com.solelogic.repository.AttendanceSpringDataRepository;

@Service
@Transactional
public class AttendanceService {
	@Autowired
	private AttendanceSpringDataRepository repository;
	@Autowired
	public EmployeeService serv;

	/**
	 * It will find emp by name and will check his checkin Status.
	 * 
	 * @param name
	 */
	public Attendance checkIn(String name) {
		Attendance att = null;
		Employee emp = serv.findEmployeeByName(name);
		if (null != emp) {
			att = repository.findAttendanceByEmpIdAndDate(emp.getId(), LocalDate.now());
			if (null == att) {
				System.out.println("Employee will be checked in");
				att = new Attendance(emp.getId(), "Present", LocalDate.now(), LocalTime.now());
				repository.save(att);

			} else {
				System.out.println("Employee already checked in today at time: " + att.getCheck_in());
			}
		}
		return att;
	}

	/**
	 * it will get employee name and then will print his checkout time.
	 * 
	 * @param name
	 */
	public Attendance checkOut(String name) {
        Attendance att = null;
		Employee emp = serv.findEmployeeByName(name);
		if (null != emp) {
			att = repository.findAttendanceByEmpIdAndDate(emp.getId(), LocalDate.now());
			att.getCheck_out();
			if (null == att.getCheck_out()) {
				att.setCheck_out(LocalTime.now());
				System.out.println("Employee will be checkedout at " + att.getCheck_out());
				att.setCheck_out(LocalTime.now());

			} else {
				System.out.println("Employee alredy checkedOut ");

			}
		}
		return att;
	}

	/**
	 * It will return the attendance report from list.
	 * 
	 * @param name
	 * @param date
	 * @param date2
	 */

	public void attendanceReportByDate(String name, LocalDate date, LocalDate date2) {
		Employee emp = serv.findEmployeeByName(name);
		if (null != emp) {
			List<Attendance> att = repository.findAttendanceByEmpIdAndDate(emp.getId(), date, date2);
			for (Attendance at : att) {
				System.out.println(
						"The name of the employee is " + emp.getName() + " And the check in TIme : " + at.getCheck_in()
								+ " ANd the CheckOut time : " + at.getCheck_out() + " And Date : " + at.getDate());
			}
		}
	}

}
