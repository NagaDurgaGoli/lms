package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.BooksIssued;


	@Repository
	public interface BooksIssuedDao extends JpaRepository<BooksIssued,Long> 
	{
		List<BooksIssued> findAll();
		void deleteById(Long issueId);
	}


