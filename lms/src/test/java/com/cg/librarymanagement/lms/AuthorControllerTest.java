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

import com.cg.librarymanagement.lms.controller.AuthorController;
import com.cg.librarymanagement.lms.dtos.Author;
import com.cg.librarymanagement.lms.service.AuthorService;


@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest 
{
	@Mock
	AuthorService authorService;
	@InjectMocks
	AuthorController authorController;
	
	@Test
	public void testaddAuthor() 
    {
	 Author author=new Author();
	 Mockito.when(authorController.addAuthor(author)).thenReturn(author);
	 assertEquals(author,authorController.addAuthor(author));
	  }
	
	@Test
	public void testupdateAuthor() {
		
		Author author=new Author();
		Long id=156787L;
		Mockito.when(authorController.updateAuthor(id,author)).thenReturn(author);
         assertEquals(author,authorController.updateAuthor(id, author));
		    }
	
	@Test
	 public void testRemoveAuthor()
	 { 
	    Long id=1234L;
		 Mockito.when(authorController.removeAuthor(id)).thenReturn("Author deleted Sucessfully");
	        assertEquals("Author deleted Sucessfully",authorController.removeAuthor(id));
		 
	 }
	
	 
	 @Test
	 public void testgetAllAuthors() {
		 List<Author> author=new ArrayList<Author>();
	       Mockito.when(authorController.getAllAuthors()).thenReturn(author);
	        assertEquals(author,authorController.getAllAuthors());
	 }
	 
	  @Test
	 public void testgetAuthorById() 
	  {
		  Author author=new Author();
			 Long id=1756924L;
			 Mockito.when(authorController.getAuthorById(id)).thenReturn(author);
		        assertEquals(author,authorController.getAuthorById(id));


}
}
