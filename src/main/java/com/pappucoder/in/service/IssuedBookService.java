package com.pappucoder.in.service;

import java.util.List;

import com.pappucoder.in.bean.IssuedBookBean;
import com.pappucoder.in.entity.IssueDetails;

public interface IssuedBookService {

	public List<IssuedBookBean> getAllIssuedBooks();

	public void saveIssuedBook(IssuedBookBean issuedBookBean);
	
}
