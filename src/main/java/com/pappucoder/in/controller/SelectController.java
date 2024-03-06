package com.pappucoder.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pappucoder.in.entity.Books;
import com.pappucoder.in.entity.Student;
import com.pappucoder.in.service.BookService;
import com.pappucoder.in.service.IssuedBookService;
import com.pappucoder.in.service.StudentService;

@Controller
public class SelectController {

	private IssuedBookService issuedBookService;

	@Autowired
	private BookService bookService;

	@Autowired
	private StudentService studentService;

	public SelectController(IssuedBookService issuedBookService) {
		this.issuedBookService = issuedBookService;
	}

	@GetMapping("/selectbook")
	public ModelAndView selectBook() {

		List<Books> books = issuedBookService.getBooks();
		ModelAndView model = new ModelAndView();
		model.addObject("bookList", books);
		model.setViewName("selectbook");

		return model;

	}

	@GetMapping("/selectstudent")
	public ModelAndView selectStudent(@RequestParam("bookId") Long bookId) {
		Books books = bookService.getBookById(bookId);
		List<Student> allActiveStudent = studentService.getAllActiveStudent();
		ModelAndView model = new ModelAndView();
		model.addObject("bookList", books);
		model.addObject("bookId", bookId);
		model.addObject("allStudentList", allActiveStudent);
		model.setViewName("selectstudent");

		return model;

	}

	@GetMapping("/confrimed")
	public ModelAndView issueComfrimed(
			@RequestParam("studentId") Long studentId, 
			@RequestParam("bookId") Long bookId) {
		
		Books book = bookService.getBookById(bookId);
		Student student = studentService.getStudent(studentId);
		String msg = issuedBookService.saveIssuedEntry(book, student);
		ModelAndView model = new ModelAndView();
		model.addObject("book", book.getBookName());
		model.addObject("student", student.getStudentName());
		model.addObject("msg", msg);

		model.setViewName("issueconfrimed");

		return model;

	}
}
