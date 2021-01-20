package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.Book;




@Repository
public interface BookDao extends JpaRepository<Book,Long> {
	

	List<Book> findAll();
	void deleteById(Long id);
	
}
