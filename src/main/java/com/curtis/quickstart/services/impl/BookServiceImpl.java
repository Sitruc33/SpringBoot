package com.curtis.quickstart.services.impl;

import org.springframework.stereotype.Service;

import com.curtis.quickstart.domain.entities.BookEntity;
import com.curtis.quickstart.repositories.BookRepository;
import com.curtis.quickstart.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public BookEntity createBook(String isbn, BookEntity book) {
		// TODO Auto-generated method stub
		book.setIsbn(isbn);
		return bookRepository.save(book);
	}
	
	
	

}
