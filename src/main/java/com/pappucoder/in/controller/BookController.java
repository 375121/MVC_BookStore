package com.pappucoder.in.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pappucoder.in.entity.Books;
import com.pappucoder.in.service.BookService;

@Controller
//@RequestMapping("/book")
public class BookController {
	 
	private BookService bookService;
	
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}

	@GetMapping("/book")
	public ModelAndView mainBookPage() {

		List<Books> bookList = bookService.getAllBookDetails();
		
		ModelAndView model = new ModelAndView();
		model.addObject("bookList",bookList);
		model.setViewName("book");
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView addNewBook() {
		Books newbook= new Books();
		
		ModelAndView model = new ModelAndView();
		model.addObject("newbook", newbook);
		model.setViewName("addbook");
		return model;
	}
	
	@PostMapping("/save")
	public ModelAndView saveBook(Books book) {

		List<Books> bookList = bookService.saveBookDetails(book);

		ModelAndView model = new ModelAndView();
		model.addObject("bookList", bookList);
		model.setViewName("book");
		return model;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId") Long bookId) {
		
		List<Books> bookList = bookService.deleteBook(bookId);
		
		ModelAndView model = new ModelAndView();
		model.addObject("bookList", bookList);
		model.setViewName("book");
		return model;
	}
	
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId") Long bookId) {
		
		Books oldbook = bookService.getBookById(bookId);
		
		ModelAndView model = new ModelAndView();
		model.addObject("newbook", oldbook);
		model.setViewName("addbook");
		return model;
	}
	
	@PostMapping("/editconfrim")
	public ModelAndView confrimEditBook(Books book) {
		
		System.out.println(book);
		Books newbook= new Books();
		
		ModelAndView model = new ModelAndView();
		model.addObject("newbook", newbook);
		model.setViewName("book");
		return model;
	}
	
	
}
