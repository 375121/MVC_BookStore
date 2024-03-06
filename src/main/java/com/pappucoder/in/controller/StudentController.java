package com.pappucoder.in.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pappucoder.in.entity.Student;
import com.pappucoder.in.service.StudentService;

@Controller
//@RequestMapping("/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/student/allstudent")
	public ModelAndView studentDetailsPage() {

		List<Student> allStudent = studentService.getAllStudent();

		ModelAndView model = new ModelAndView();
		model.addObject("allStudentList", allStudent);
		model.setViewName("student");

		return model;
	}

	@GetMapping("/student/addstudent")
	public ModelAndView goAddStudentPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("newstudent", new Student());
		model.setViewName("addStudent");

		return model;
	}

	@PostMapping("/student/save")
	public ModelAndView saveStudentDetailsPage(Student student) {

		studentService.saveStudentDetails(student);

		List<Student> allStudent = studentService.getAllStudent();

		ModelAndView model = new ModelAndView();
		model.addObject("allStudentList", allStudent);
		model.setViewName("student");

		return model;
	}

	@GetMapping("/student/delete")
	public ModelAndView deleteStudent(@RequestParam("studentId") Long studentId) {

		studentService.deleteStudent(studentId);

		List<Student> allStudent = studentService.getAllStudent();
		ModelAndView model = new ModelAndView();
		model.addObject("allStudentList", allStudent);
		model.setViewName("student");
		return model;
	}

	@GetMapping("/student/edit")
	public ModelAndView editStudent(@RequestParam("studentId") Long studentId) {

		Student oldStudent = studentService.getStudent(studentId);

		ModelAndView model = new ModelAndView();
		model.addObject("newstudent", oldStudent);
		model.setViewName("addStudent");
		return model;
	}

	
}
