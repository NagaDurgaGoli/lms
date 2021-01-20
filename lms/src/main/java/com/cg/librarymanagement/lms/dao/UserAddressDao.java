package com.cg.librarymanagement.lms.dao;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.librarymanagement.lms.dtos.UserAddress;

@Repository
public interface UserAddressDao extends JpaRepository<UserAddress,Integer>{

}
