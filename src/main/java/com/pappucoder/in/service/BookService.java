package com.pappucoder.in.service;

import java.util.List;

import com.pappucoder.in.entity.Books;

public interface BookService {

	public List<Books> saveBookDetails(Books book);
	
	public List<Books> getAllBookDetails();
	
	public List<Books> deleteBook(Long bookId);
	
	public List<Books> editBook(Books book);
	
	public Books getBookById(Long bookId);
	
}
