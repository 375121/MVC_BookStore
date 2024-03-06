package com.pappucoder.in.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pappucoder.in.entity.Student;
import com.pappucoder.in.repository.StudentRepository;
import com.pappucoder.in.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void saveStudentDetails(Student student) {

		studentRepository.save(student);
	}

	public List<Student> getAllActiveStudent() {

		List<Student> activeStudentList = studentRepository.findByIsActiveTrue();

		return activeStudentList;
	}

	public List<Student> getAllBlockedStudent() {

		List<Student> bolckedStudentList = studentRepository.findByBolckedTrue();

		return bolckedStudentList;
	}

	public Student getStudent(Long studentId) {
		
		Student student = studentRepository.findByStudentId(studentId);
		
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudents = studentRepository.findAll();
		return allStudents;
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.delete(this.getStudent(studentId));
	}

}
