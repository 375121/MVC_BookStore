package com.pappucoder.in.bean;

import java.util.Date;

public class IssuedBookBean {

	private Long bookId;
	
	private String bookName;

	private Long studentId;
	
	private String studentName;

	private String remark;

	private Date issueDate;

	private Date returnDate;

	private Date issueExpireDate;

	private Boolean isActive;


	public Long getBookId() {
		return bookId;
	}

	

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getIssueExpireDate() {
		return issueExpireDate;
	}

	public void setIssueExpireDate(Date issueExpireDate) {
		this.issueExpireDate = issueExpireDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "IssuedBookBean [bookId=" + bookId + ", studentId=" + studentId + ", remark=" + remark + ", issueDate="
				+ issueDate + ", returnDate=" + returnDate + ", issueExpireDate=" + issueExpireDate + ", isActive="
				+ isActive + "]";
	}

}
