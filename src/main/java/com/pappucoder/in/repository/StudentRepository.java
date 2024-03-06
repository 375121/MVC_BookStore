package com.pappucoder.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pappucoder.in.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByStudentId(Long studentId);
	
	List<Student> findByIsActiveTrue();
	
	List<Student> findByBolckedTrue();
	
}
