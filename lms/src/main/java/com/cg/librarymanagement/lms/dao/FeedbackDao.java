package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.Feedback;


@Repository
public interface FeedbackDao extends JpaRepository<Feedback,Integer>{
	// List<Feedback> viewFeedbackList();
	List<Feedback> findAll();
	void deleteById(int id);

}