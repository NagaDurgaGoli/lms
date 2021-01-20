package com.cg.librarymanagement.lms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.Author;



@Repository
public interface AuthorDao extends JpaRepository<Author,Long>
{
	List<Author> findAll();
	void deleteById(Long id);
}
