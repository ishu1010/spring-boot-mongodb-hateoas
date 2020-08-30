package com.example.spring.mongo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring.mongo.dto.BookDTO;
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

	@GetMapping(path = "/catalogue")
	public ResponseEntity<List<BookDTO>> getBookCatalog() {
		List<BookDTO> books = bookService.getAllResource();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@GetMapping(path = "{bookId}")
	public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable int bookId) throws Exception {
		BookDTO book = bookService.getResourceById(bookId);
		EntityModel<BookDTO> resource = EntityModel.of(book);
		WebMvcLinkBuilder link_catalogue= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getBookCatalog());
		resource.add(link_catalogue.withRel("catalogue"));
		WebMvcLinkBuilder link_order= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookOrderController.class).getOrderById(book.getId()));
		resource.add(link_order.withRel("order"));
		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}

	@PostMapping(path = "/save-resource")
	public ResponseEntity<Object> saveBook(@RequestBody BookDTO bookDTO) {
		BookDTO savedBook = bookService.createResource(bookDTO);
	    URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("book/{bookId}").buildAndExpand(savedBook.getId()).toUri();
		return ResponseEntity.ok(location);
	}

	@PutMapping(path = "/update-resource")
	public ResponseEntity<Object> updateBookDetails(@RequestBody BookDTO bookDTO) {
		BookDTO updatedBook = bookService.updateResource(bookDTO);
		URI location = ServletUriComponentsBuilder.fromPath("book/{bookId}").buildAndExpand(updatedBook.getId()).toUri();
		return new ResponseEntity(HttpStatus.ACCEPTED).created(location).build();
	}

	@DeleteMapping(path = "/delete-resource")
	public ResponseEntity<String> deleteBook(@RequestBody BookDTO bookDTO) {
		bookService.deleteResource(bookDTO);
		return ResponseEntity.status(HttpStatus.OK).body("book deleted!");
	}

}
