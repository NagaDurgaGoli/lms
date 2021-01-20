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
import com.cg.librarymanagement.lms.controller.BooksOrderController;
import com.cg.librarymanagement.lms.dtos.BookOrder;
import com.cg.librarymanagement.lms.service.BookOrderService;
@ExtendWith(MockitoExtension.class)
public class BookOrderControllerTest {
	@Mock
    BookOrderService bookorderservice;
	@InjectMocks
	BooksOrderController bookordercontroller;

	@Test
	public void testPlaceBookOrder()
	       {
		        BookOrder bookorder=new BookOrder();
		        Mockito.when(bookordercontroller.addBookOrder(bookorder)).thenReturn(bookorder);
		        assertEquals(bookorder,bookordercontroller.addBookOrder(bookorder));
		    }
	
	@Test
	public void testupdateBookOrder() {
		
		BookOrder bookorder=new BookOrder();
		Long id=156787L;
		Mockito.when(bookordercontroller.updateBookOrder(id, bookorder)).thenReturn(bookorder);
         assertEquals(bookorder,bookordercontroller.updateBookOrder(id, bookorder));
		    }
	
	 @Test
	 public void testOrderById() {
		BookOrder bookorder=new BookOrder();
		 Long id=1234L;
		 Mockito.when(bookordercontroller.getBookOrderById(id)).thenReturn(bookorder);
	        assertEquals(bookorder,bookordercontroller.getBookOrderById(id));
	        }
	 
	 @Test
	 public void testviewBookOrderList() {
		 List<BookOrder> bookorder=new ArrayList<BookOrder>();
	       Mockito.when(bookordercontroller.getLibraryBooks()).thenReturn(bookorder);
	        assertEquals(bookorder,bookordercontroller.getLibraryBooks());
	 }
	 
	@Test
	 public void testRemoveBookOrder()
	 { 
	    Long id=1234L;
		 Mockito.when(bookordercontroller.removeBook(id)).thenReturn("Book deleted Sucessfully");
	        assertEquals("Book deleted Sucessfully",bookordercontroller.removeBook(id));
		 
	 }


	
}
