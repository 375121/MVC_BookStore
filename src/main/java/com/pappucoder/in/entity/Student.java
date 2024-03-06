package com.pappucoder.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	private String studentName;

	private String semester;

	private Boolean isActive;
	
	private Boolean bolcked;
	
	private Boolean bookIssued;
	
	private String unNumber;
	
	private Long dueAmount;
	
	private String remark;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getBolcked() {
		return bolcked;
	}

	public void setBolcked(Boolean bolcked) {
		this.bolcked = bolcked;
	}

	public Boolean getBookIssued() {
		return bookIssued;
	}

	public void setBookIssued(Boolean bookIssued) {
		this.bookIssued = bookIssued;
	}

	public String getUnNumber() {
		return unNumber;
	}

	public void setUnNumber(String unNumber) {
		this.unNumber = unNumber;
	}

	public Long getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Long dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester
				+ ", isActive=" + isActive + ", bolcked=" + bolcked + ", bookIssued=" + bookIssued + ", unNumber="
				+ unNumber + ", dueAmount=" + dueAmount + ", remark=" + remark + "]";
	}

	
	
	
}
