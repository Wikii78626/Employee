package com.solelogic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solelogic.entity.Attendance;

@Repository
public interface AttendanceSpringDataRepository extends JpaRepository<Attendance, Integer> {
	public Attendance findAttendanceByEmpIdAndDate(int id, LocalDate date);

	@Query("SELECT a FROM Attendance a WHERE empId = :empId and date >=:date and date <= :date2")
	public List<Attendance> findAttendanceByEmpIdAndDate(int empId, LocalDate date, LocalDate date2);

}
