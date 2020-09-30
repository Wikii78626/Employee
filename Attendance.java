package com.solelogic.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Attendance Entity
 * 
 * @author Dell
 *
 */
@Entity
public class Attendance {
	@Id
	@GeneratedValue
	private int attend_id;
	@Column(name = "EMP_ID")
	private int empId;
	public String attendance;
	public LocalDate date;
	public LocalTime check_in;
	public LocalTime check_out;

	public int getEmpId() {
		return empId;
	}

	public Attendance(int empId, String attendance, LocalDate date, LocalTime time) {
		super();
		this.empId = empId;
		this.attendance = attendance;
		this.date = date;
		this.check_in = time;

	}

	public LocalTime getCheck_out() {
		return check_out;
	}

	public void setCheck_out(LocalTime check_out) {
		this.check_out = check_out;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	protected Attendance() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getCheck_in() {
		return check_in;
	}

	public void setCheck_in(LocalTime check_in) {
		this.check_in = check_in;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

}