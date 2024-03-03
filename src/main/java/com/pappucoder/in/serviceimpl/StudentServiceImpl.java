package com.pappucoder.in.serviceimpl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pappucoder.in.entity.Student;
import com.pappucoder.in.repository.StudentRepository;
import com.pappucoder.in.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Value("${app.bookstore.issuedDays}")
	private String issuedDays;

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void saveStudentDetails() {
		Date date = new Date();
//		Student student = new Student("stdName", date, getExpirationDateForAwsS3(), 1234L);

//		studentRepository.save(student);
	}

	private Date getExpirationDateForAwsS3() {
		java.util.Date expiration = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(expiration);
		int daysToAdd = Integer.parseInt(issuedDays);
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		return cal.getTime();
	}

//	private String dateFormattor(Date date) {
//	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//	return formatter.format(date);
//}
}
