package com.cg.librarymanagement.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.librarymanagement.lms.controller.BooksIssuedController;
import com.cg.librarymanagement.lms.dtos.BooksIssued;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;
import com.cg.librarymanagement.lms.service.BooksIssuedService;




@ExtendWith(MockitoExtension.class)

public class BooksIssuedControllerTest {
	@Mock
    BooksIssuedService booksIssuedervice;
	@InjectMocks
	BooksIssuedController booksissuedcontroller;
     @Test
	public void testaddIssuedBooks() 
          {
    	 BooksIssued booksIssued=new BooksIssued();
		 Mockito.when(booksissuedcontroller.addBooksIssued(booksIssued)).thenReturn(booksIssued);
		 assertEquals(booksIssued,booksissuedcontroller.addBooksIssued(booksIssued));
		  }
	@Test
	public void testupdateBooksIssued() throws BookNotFoundException {
		
		BooksIssued booksIssued=new BooksIssued();
		Long id=2L;
		Mockito.when(booksissuedcontroller.updateBooksIssued(id, booksIssued)).thenReturn(booksIssued);
         assertEquals(booksIssued,booksissuedcontroller.updateBooksIssued(id, booksIssued));
		    }
	
	@Test
	 public void testviewBookSIssuedById() throws BookNotFoundException {
		BooksIssued booksIssued=new BooksIssued();
		 Long id=3L;
		 Mockito.when(booksissuedcontroller.getBooksIssuedById(id)).thenReturn( booksIssued);
	        assertEquals(booksIssued,booksissuedcontroller.getBooksIssuedById(id));

		 
	 }

	
	 @Test
	 public void testviewBookList() {
		 List<BooksIssued> booksissued=new ArrayList<BooksIssued>();
	       Mockito.when(booksissuedcontroller.getAllBooksIssued()).thenReturn(booksissued);
	        assertEquals(booksissued,booksissuedcontroller.getAllBooksIssued());
	 }
	/*@Test
	 public void testRemoveBook()
	 { 
	    Long id=1234L;
		 Mockito.when(booksissuedcontroller.removeBook(id)).thenReturn("Book deleted Sucessfully");
	        assertEquals("Book deleted Sucessfully",bookcontroller.removeBook(id));
		 
	 }*/


	
}
	




