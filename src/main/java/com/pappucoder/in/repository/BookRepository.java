package com.pappucoder.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pappucoder.in.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long>{
	

}
