package com.example.spring.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mongo.model.Book;
import com.example.spring.mongo.service.BookService;
/**
 * book store request handler
 * @author ishu1010	
 */
@RestController
@RequestMapping("/book")
public class BookStoreController {

	private BookService bookService;

	public BookStoreController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getbook(@PathVariable Integer id) {
		Optional<Book> bookOp = bookService.getBook(id);
		bookOp.orElseThrow(IllegalArgumentException::new);
		return ResponseEntity.status(HttpStatus.OK).body(bookOp.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book requestBook) {
		Book book = bookService.saveBook(requestBook);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book requestBook) {
		Book book = bookService.updateBook(requestBook);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteBook(@RequestBody Book requestBook) {
		bookService.deleteBook(requestBook);
		return ResponseEntity.status(HttpStatus.OK).body("done!");
	}

}
