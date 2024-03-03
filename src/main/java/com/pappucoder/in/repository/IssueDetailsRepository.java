package com.pappucoder.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pappucoder.in.entity.IssueDetails;

public interface IssueDetailsRepository extends JpaRepository<IssueDetails, Long>{

	List<IssueDetails> findByIsActiveTrue();
	
}
