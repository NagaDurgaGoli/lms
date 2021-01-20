package com.cg.librarymanagement.lms.dtos;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="feedback_details")
public class Feedback {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int fid;
	
    private Date feedbackDate;
    
 
	private String description;
    
  
	private String rating;
    

	private String comments;
    

	
	public int getId() {
		return fid;
	}
	public void setId(int id) {
		this.fid = id;
	}
	
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Feedback() {
		super();
	}
	public Feedback(Date feedbackDate, String description, String rating, String comments) {
		super();
		
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	public Feedback(int id, Date feedbackDate, String description, String rating, String comments) {
		super();
		this.fid = id;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feedback [id=");
		builder.append(fid);
		builder.append(", feedbackDate=");
		builder.append(feedbackDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", comments=");
		builder.append(comments);
		builder.append("]");
		return builder.toString();
	}
	
}