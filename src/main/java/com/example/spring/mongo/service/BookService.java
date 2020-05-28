package com.example.spring.mongo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.mongo.dto.BookDTO;
import com.example.spring.mongo.model.Book;
import com.example.spring.mongo.repository.BookRepository;
import com.example.spring.mongo.utils.BookMapper;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<BookDTO> getAllResource() {
		List<Book> books = bookRepository.findAll();
		return BookMapper.bookToBookDtoMapperList(books);
	}

	@Transactional
	public BookDTO createResource(BookDTO bookDTO) {
		Book book = bookRepository.save(BookMapper.bookDtoToBookMapper(bookDTO));
		return BookMapper.bookToBookDtoMapper(book);

	}

	@Transactional
	public BookDTO updateResource(BookDTO bookDTO) {
		return createResource(bookDTO);
	}

	@Transactional
	public void deleteResource(BookDTO bookDTO) {
		bookRepository.delete(BookMapper.bookDtoToBookMapper(bookDTO));
	}

}
