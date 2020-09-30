package com.solelogic.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.solelogic.entity.Attendance;

@Repository
@Transactional
public class AttendanceRepository {
	@PersistenceContext
	EntityManager entityManager;

	public void saveEntity(Attendance att) {
		entityManager.persist(att);
	}

	public Attendance findByEmpIdAndDate(int empId, LocalDate date) {

		TypedQuery<Attendance> query = entityManager
				.createQuery("SELECT a FROM Attendance a WHERE empId = :empId and date =:date", Attendance.class);
		query.setParameter("empId", empId);
		query.setParameter("date", date);
		Attendance att = null;
		try {
			att = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("No record found for employee attendance");
		}
		return att;
	}

	public List<Attendance> findAttendanceByEmpIdAndDate(int empId, LocalDate date1, LocalDate date2) {

		TypedQuery<Attendance> query = entityManager.createQuery(
				"SELECT a FROM Attendance a WHERE empId = :empId and date >=:date and date <= :date2",
				Attendance.class);
		query.setParameter("empId", empId);
		query.setParameter("date", date1);
		query.setParameter("date2", date2);
		List<Attendance> att = null;
		try {
			att = query.getResultList();
		} catch (Exception e) {
			System.out.println("No record found for employee attendance");
		}
		return att;
	}

	public Attendance update(Attendance att) {
		return entityManager.merge(att);
	}

}
