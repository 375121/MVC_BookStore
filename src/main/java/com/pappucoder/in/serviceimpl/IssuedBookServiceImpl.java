package com.pappucoder.in.serviceimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pappucoder.in.bean.IssuedBookBean;
import com.pappucoder.in.entity.IssueDetails;
import com.pappucoder.in.repository.BookRepository;
import com.pappucoder.in.repository.IssueDetailsRepository;
import com.pappucoder.in.repository.StudentRepository;
import com.pappucoder.in.service.IssuedBookService;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

	private BookRepository bookRepository;

	private IssueDetailsRepository issuedetailsRepository;

	private StudentRepository studentRepository;

	public IssuedBookServiceImpl(BookRepository bookRepository, IssueDetailsRepository issuedetailsRepository,
			StudentRepository studentRepository) {

		this.bookRepository = bookRepository;
		this.issuedetailsRepository = issuedetailsRepository;
		this.studentRepository = studentRepository;
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

	public void saveIssuedBook(IssuedBookBean issuedBookBean) {
		java.util.Date currentDate = new java.util.Date();

		if (null != issuedBookBean && null == issuedBookBean.getIssueDate()) {

			issuedBookBean.setIssueDate(currentDate);
			issuedBookBean.setIssueExpireDate(getExpirationDate(currentDate));
		}
		issuedBookBean.setLastUpdateDate(currentDate);

		ObjectMapper mapper = new ObjectMapper();
		IssueDetails issueDetails = mapper.convertValue(issuedBookBean, IssueDetails.class);

		IssueDetails save = issuedetailsRepository.save(issueDetails);

	}

	private Date getExpirationDate(Date issueDate) {
//		java.util.Date expiration = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int daysToAdd = Integer.parseInt("7");
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		return cal.getTime();
	}
}
