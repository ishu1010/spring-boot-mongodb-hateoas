package com.example.spring.mongo.service;

import static com.example.spring.mongo.test.utils.TestHelper.getBookDTOList;
import static com.example.spring.mongo.test.utils.TestHelper.getBookList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.example.spring.mongo.dto.BookDTO;
import com.example.spring.mongo.model.Book;
import com.example.spring.mongo.repository.BookRepository;
public class BookServiceTest {
	@Mock
	BookRepository repository;
	
	@Spy
	@InjectMocks
	BookService service;
	private Book book;
	private BookDTO bookDTO;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		book = new Book(101, "Mokito", "publisher", 15.00);
		bookDTO = new BookDTO(101, "Mokito", "publisher", 15.00);
	}
	
	@Test
	public void getAllResource_shouldReturn_ListOfBookDTO_Successfully() {
		when(repository.findAll()).thenReturn(getBookList());
		List<BookDTO> books= service.getAllResource();
		assertEquals(getBookDTOList().toString(), books.toString());
		verify(service, times(1)).getAllResource();
	}
	
	@Test
	public void saveBook_shouldReturn_BookDTOSuccessful() {
		when(repository.save(Mockito.<Book>any())).thenReturn(book);
		BookDTO book= service.createResource(bookDTO);
		assertEquals(bookDTO.toString(), book.toString());
		verify(service, times(1)).createResource(Mockito.<BookDTO>any());
	}
	
	@Test
	public void updateBook_shouldReturn_BookDTOSuccessful() {
		when(repository.save(Mockito.<Book>any())).thenReturn(book);
		BookDTO book= service.updateResource(bookDTO);
		assertEquals(bookDTO.toString(), book.toString());
		verify(service, times(1)).updateResource(Mockito.<BookDTO>any());
	}
	
	
	@Test
	public void deleteBook_shouldReturnSuccessful() {
		doNothing().when(repository).delete(Mockito.<Book>any());
		service.deleteResource(bookDTO);
		verify(service, times(1)).deleteResource(Mockito.<BookDTO>any());
	}
}
