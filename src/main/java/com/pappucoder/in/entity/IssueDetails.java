package com.pappucoder.in.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IssueDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issuedId;

	private Long bookId;

	private Long studentId;

	private Date issueDate;

	private Date returnDate;
	
	private Date issueExpireDate;
	
	private String remark;
	
	private Boolean isActive;
	
	public Long getIssuedId() {
		return issuedId;
	}

	public void setIssuedId(Long issuedId) {
		this.issuedId = issuedId;
	}

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
		return "IssueDetails [issuedId=" + issuedId + ", bookId=" + bookId + ", studentId=" + studentId + ", remark="
				+ remark + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", issueExpireDate="
				+ issueExpireDate + ", isActive=" + isActive + "]";
	}

}
