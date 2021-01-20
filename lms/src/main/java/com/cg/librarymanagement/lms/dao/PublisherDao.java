package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.Publishers;


@Repository

public interface PublisherDao extends JpaRepository<Publishers,Integer>{
	
	List<Publishers> findAll();
	void deleteById(int id);

	
	
	
	
}