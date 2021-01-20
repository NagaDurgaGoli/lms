package com.cg.librarymanagement.lms;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.librarymanagement.lms.controller.BookController;
import com.cg.librarymanagement.lms.dtos.Book;
import com.cg.librarymanagement.lms.service.BookService;
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
	@Mock
    BookService bookservice;
	@InjectMocks
	BookController bookcontroller;
     @Test
	public void testaddBook() 
          {
    	 Book book=new Book();
		 Mockito.when(bookcontroller.addBook(book)).thenReturn(book);
		 assertEquals(book,bookcontroller.addBook(book));
		  }
	@Test
	public void testupdateBook() {
		
		Book book=new Book();
		Long id=156787L;
		Mockito.when(bookcontroller.updateBook(id, book)).thenReturn(book);
         assertEquals(book,bookcontroller.updateBook(id, book));
		    }
	
	 @Test
	 public void testviewBookBySubject() 
	 {
		List<Book> book=new ArrayList<Book>();
		String subject="john";
		Mockito.when(bookcontroller.getBookBySubject(subject)).thenReturn(book);
	    assertEquals(book,bookcontroller.getBookBySubject(subject));
    }
	@Test
	 public void testviewBookList() 
	 {
		   List<Book> book=new ArrayList<Book>();
	       Mockito.when(bookcontroller.getLibraryBooks()).thenReturn(book);
	       assertEquals(book,bookcontroller.getLibraryBooks());
	 }
	@Test
	 public void testRemoveBook()
	 { 
	    Long id=1234L;
		 Mockito.when(bookcontroller.removeBook(id)).thenReturn("Book deleted Sucessfully");
	        assertEquals("Book deleted Sucessfully",bookcontroller.removeBook(id));
		 
	 }


	
}
