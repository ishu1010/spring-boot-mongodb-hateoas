package com.example.spring.mongo.service;

import java.nio.file.NotDirectoryException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.mongo.dto.BookDTO;
import com.example.spring.mongo.model.Book;
import com.example.spring.mongo.repository.BookRepository;
import com.example.spring.mongo.utils.BookMapper;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper mapper;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<BookDTO> getAllResource() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(book -> mapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public BookDTO createResource(BookDTO bookDTO) {
		Book book = bookRepository.save(mapper.map(bookDTO, Book.class));
		return mapper.map(book, BookDTO.class);

	}

	@Transactional
	public BookDTO updateResource(BookDTO bookDTO) {
		return createResource(bookDTO);
	}

	@Transactional
	public void deleteResource(BookDTO bookDTO) {
		bookRepository.delete(mapper.map(bookDTO, Book.class));
	}

	public BookDTO getResourceById(int bookId) throws Exception {
		Optional<Book> bookopt = bookRepository.findById(bookId);
		if (bookopt.isPresent()) return mapper.map(bookopt.get(), BookDTO.class);
		throw new Exception("Not found");
	}

}
