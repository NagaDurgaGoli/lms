package com.cg.librarymanagement.lms.dao;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.librarymanagement.lms.dtos.*;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	

	List<User> findAll();

}
