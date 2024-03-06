package com.pappucoder.in.service;

import java.util.List;

import com.pappucoder.in.entity.Student;

public interface StudentService {

	public Student getStudent(Long studentId);
	
	public List<Student> getAllBlockedStudent();
	
	public List<Student> getAllActiveStudent();
	
	public List<Student> getAllStudent();
	
	public void saveStudentDetails(Student student);
	
	public void deleteStudent(Long studentId);
	
	
	
	
	
}
