package com.pappucoder.in.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	private String bookSerialId;

	private String bookName;

	private String authorName;

	private String edition;

	private Boolean isActive;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookSerialId() {
		return bookSerialId;
	}

	public void setBookSerialId(String bookSerialId) {
		this.bookSerialId = bookSerialId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookSerialId=" + bookSerialId + ", bookName=" + bookName + ", authorName="
				+ authorName + ", edition=" + edition + ", isActive=" + isActive + "]";
	}

}
