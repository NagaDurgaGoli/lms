package com.cg.librarymanagement.lms.exception;

public class PublisherNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PublisherNotFoundException(String message)
	{
		super(message);
	}
}
