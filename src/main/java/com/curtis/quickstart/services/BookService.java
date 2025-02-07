package com.curtis.quickstart.services;

import java.util.List;
import java.util.Optional;

import com.curtis.quickstart.domain.entities.BookEntity;

public interface BookService {
	
	BookEntity createUpdateBook(String isbn, BookEntity book);

	List<BookEntity> findAll();

	Optional<BookEntity> findOne(String isbn);

	boolean isExists(String isbn);

	BookEntity partialUpdate(String isbn, BookEntity bookEntity);

}
