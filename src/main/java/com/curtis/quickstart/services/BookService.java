package com.curtis.quickstart.services;

import java.util.List;

import com.curtis.quickstart.domain.entities.BookEntity;

public interface BookService {
	
	BookEntity createBook(String isbn, BookEntity book);

	List<BookEntity> findAll();

}
