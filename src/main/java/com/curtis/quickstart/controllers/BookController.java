package com.curtis.quickstart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	

}
