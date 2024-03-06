package com.pappucoder.in.serviceimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pappucoder.in.bean.IssuedBookBean;
import com.pappucoder.in.entity.Books;
import com.pappucoder.in.entity.IssueDetails;
import com.pappucoder.in.entity.Student;
import com.pappucoder.in.repository.BookRepository;
import com.pappucoder.in.repository.IssueDetailsRepository;
import com.pappucoder.in.repository.StudentRepository;
import com.pappucoder.in.service.BookService;
import com.pappucoder.in.service.IssuedBookService;

import jakarta.transaction.Transactional;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

	private BookRepository bookRepository;

	private IssueDetailsRepository issuedetailsRepository;

	private StudentRepository studentRepository;

	@Autowired
	private BookService bookService;

	public IssuedBookServiceImpl(BookRepository bookRepository, IssueDetailsRepository issuedetailsRepository,
			StudentRepository studentRepository) {

		this.bookRepository = bookRepository;
		this.issuedetailsRepository = issuedetailsRepository;
		this.studentRepository = studentRepository;
	}

	public List<Books> getBooks() {
		return bookService.getAllBookDetails();
	}

	public List<IssuedBookBean> getAllIssuedBooks() {

		List<IssueDetails> issueDetailsList = issuedetailsRepository.findByIsActiveTrue();
		ObjectMapper mapper = new ObjectMapper();

		List<IssuedBookBean> issuedBookBeanList = new ArrayList<>();
		for (IssueDetails issueDetails : issueDetailsList) {
			IssuedBookBean issuedBookBean = mapper.convertValue(issueDetails, IssuedBookBean.class);
			issuedBookBeanList.add(issuedBookBean);
		}

		return issuedBookBeanList;
	}

	@Transactional(rollbackOn = Exception.class)
	public String saveIssuedEntry(Books book, Student student) {

		java.util.Date currentDate = new java.util.Date();
		
		IssueDetails issueDetails =new IssueDetails();
		if (null != book && null != student) {
			issueDetails.setBookId(book.getBookId());
			issueDetails.setStudentId(student.getStudentId());
			issueDetails.setIsActive(true);
			issueDetails.setIssueDate(currentDate);
			issueDetails.setIssueExpireDate(getExpirationDate(currentDate));
			
			issuedetailsRepository.save(issueDetails);
			
			book.setIsActive(false);
			student.setBookIssued(true);
			
			bookRepository.save(book);
			studentRepository.save(student);
			
			return "Successfully";
		}

		return "failed";


	}

	private Date getExpirationDate(Date issueDate) {
//		java.util.Date expiration = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int daysToAdd = Integer.parseInt("7");
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		return cal.getTime();
	}

	@Override
	public void saveIssuedBook(IssuedBookBean issuedBookBean) {
		// TODO Auto-generated method stub
		
	}
}
