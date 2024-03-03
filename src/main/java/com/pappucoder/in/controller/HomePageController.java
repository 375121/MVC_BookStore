package com.pappucoder.in.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pappucoder.in.bean.IssuedBookBean;
import com.pappucoder.in.entity.Books;
import com.pappucoder.in.entity.IssueDetails;
import com.pappucoder.in.service.BookService;
import com.pappucoder.in.service.IssuedBookService;

@Controller
public class HomePageController {
	
	private BookService bookService;
	
	private IssuedBookService issuedBookService;
	
	public HomePageController(BookService bookService,IssuedBookService issuedBookService) {
		this.bookService = bookService;
		this.issuedBookService=issuedBookService;
	}

	@GetMapping("/home")
	public ModelAndView index() {
	
		List<IssuedBookBean> bookList= new ArrayList<>();
		IssuedBookBean issuedBookBean = new IssuedBookBean();
		issuedBookBean.setBookId(123l);
		issuedBookBean.setIsActive(true);
		issuedBookBean.setRemark("remark");
		issuedBookBean.setStudentId(111l);
		
		issuedBookService.saveIssuedBook(issuedBookBean);
		
		List<IssuedBookBean> allIssuedBooks = issuedBookService.getAllIssuedBooks();
		
		ModelAndView model = new ModelAndView();
		model.addObject("bookList", allIssuedBooks);
		model.setViewName("index");
		
		return model;
	}
}
