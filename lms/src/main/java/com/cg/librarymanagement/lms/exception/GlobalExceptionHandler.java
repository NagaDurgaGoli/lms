package com.cg.librarymanagement.lms.exception;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<?> FeedbackNotFoundHandling(FeedbackNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("FeedbackNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(PublisherNotFoundException.class)
	public ResponseEntity<?> PublisherNotFoundHandling(PublisherNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("PublisherNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(UserNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("UserNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<?> AddressNotFoundHandling(AddressNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("AddressNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> BookNotFoundHandling(BookNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("BookNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> OrderNotFoundHandling(OrderNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("OrderNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<?> AuthorNotFoundHandling(AuthorNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("AuthorNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> CustomValidationErrorHandling(MethodArgumentNotValidException exception){
		ErrorDetails errormessage=new ErrorDetails("Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<?> handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
//		ErrorDetails errormessage=new ErrorDetails("Validation Error","Incorrect Date format. Enter date in the format yyyy-mm-dd" ,new Date());
//        return new ResponseEntity(errormessage, HttpStatus.BAD_REQUEST);
//    }
//	

}
