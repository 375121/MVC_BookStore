package com.pappucoder.in.service;

import java.util.List;

import com.pappucoder.in.bean.IssuedBookBean;
import com.pappucoder.in.entity.Books;
import com.pappucoder.in.entity.Student;

public interface IssuedBookService {

	public List<IssuedBookBean> getAllIssuedBooks();

	public void saveIssuedBook(IssuedBookBean issuedBookBean);
	
	public List<Books> getBooks();
	
	public String saveIssuedEntry(Books book, Student student);
	
}
