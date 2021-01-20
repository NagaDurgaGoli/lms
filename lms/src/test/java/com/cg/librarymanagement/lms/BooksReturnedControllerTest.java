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

import com.cg.librarymanagement.lms.controller.BooksReturnedController;
import com.cg.librarymanagement.lms.dtos.BooksReturned;
import com.cg.librarymanagement.lms.service.BooksReturnedService;



@ExtendWith(MockitoExtension.class)
public class BooksReturnedControllerTest {
	
	@Mock
	BooksReturnedService booksReturnedService;
	@InjectMocks
	BooksReturnedController  booksreturnedController;
     @Test
 	public void testaddReturnedBooks() 
           {
    	 BooksReturned booksReturned=new  BooksReturned();
 		 Mockito.when(booksreturnedController.addreturnBooks(booksReturned)).thenReturn(booksReturned);
 		 assertEquals(booksReturned, booksreturnedController.addreturnBooks(booksReturned));
 		  }
     @Test
 	public void testupdateBooksReturned() {
    	 BooksReturned booksReturned=new BooksReturned();
 		Long id=23L;
 		Mockito.when(booksreturnedController.updateBooksReturned(id, booksReturned)).thenReturn(booksReturned);
          assertEquals(booksReturned,booksreturnedController.updateBooksReturned(id,booksReturned));
 		    }
     @Test
     public void testViewReturnedBooksList() {
    	 List<BooksReturned> booksissued=new ArrayList<BooksReturned>();
	       Mockito.when(booksreturnedController.viewReturnedBooksList()).thenReturn(booksissued);
	        assertEquals(booksissued,booksreturnedController.viewReturnedBooksList());
     }

}

	