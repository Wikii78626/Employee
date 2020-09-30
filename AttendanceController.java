package com.solelogic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solelogic.entity.Attendance;
import com.solelogic.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private AttendanceService service;

	@GetMapping("/checkin/{name}")
	public String checkIn(@PathVariable String name) {

		Attendance att = service.checkIn(name);
		if (null == att) {
			return "Employee Not Found ";
		} else {
			String msg = "Employee has been successfully check in at :" + att.check_in;
			return msg;
		}
	}

	@GetMapping("/checkout/{name}")
	public String checkOut(@PathVariable String name) {

		Attendance att = service.checkOut(name);
		if (null == att) {
			return "Employee never checkedIn ";
		} else
			return "Employee has been successfully checked out at " + att.getCheck_out();

	}
}
