package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.BooksReturned;



@Repository
public interface  BooksReturnedDao extends JpaRepository<BooksReturned,Long> 
{
	List<BooksReturned> findAll();
	void deleteById(Long id);
	/*@Query("select e from BooksReturned e where e.delayed_Days!=0")
	List<BooksReturned> viewDelayedBooksList();*/

	
}

