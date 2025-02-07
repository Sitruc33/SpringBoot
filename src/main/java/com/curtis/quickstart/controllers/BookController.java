package com.curtis.quickstart.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curtis.quickstart.domain.dto.BookDto;
import com.curtis.quickstart.domain.entities.BookEntity;
import com.curtis.quickstart.mappers.Mapper;
import com.curtis.quickstart.services.BookService;

@RestController
public class BookController {
	
	private Mapper<BookEntity, BookDto> bookMapper;
	
	private BookService bookService;
	
	
	
	public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
		super();
		this.bookMapper = bookMapper;
		this.bookService = bookService;
	}



	@PutMapping("/books/{isbn}")
	public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
		
		BookEntity bookEntity = bookMapper.mapFrom(bookDto);
		BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
		BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);
		return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
	}
	

	@GetMapping(path = "/books")
	public List<BookDto> listBooks() {
		
		List<BookEntity> books = bookService.findAll();
		return books.stream().map(bookMapper::mapTo).collect(Collectors.toList());
	}
	
	@GetMapping(path = "/books/{isbn}")
	public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
		
		Optional<BookEntity> foundBook =  bookService.findOne(isbn);
		return foundBook.map(bookEntity -> {
			
			BookDto bookDto = bookMapper.mapTo(bookEntity);
			return new ResponseEntity<>(bookDto, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
}
