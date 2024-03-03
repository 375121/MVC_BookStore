package com.pappucoder.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pappucoder.in.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
