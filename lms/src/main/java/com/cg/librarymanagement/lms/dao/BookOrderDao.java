package com.cg.librarymanagement.lms.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.BookOrder;

@Repository
public interface BookOrderDao extends JpaRepository<BookOrder,Long> 
{
	List<BookOrder> findAll();
	void deleteById(Long id);
	
}

