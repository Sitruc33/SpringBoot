package com.curtis.quickstart.services;

import java.util.List;
import java.util.Optional;

import com.curtis.quickstart.domain.entities.BookEntity;

public interface BookService {
	
	BookEntity createBook(String isbn, BookEntity book);

	List<BookEntity> findAll();

	Optional<BookEntity> findOne(String isbn);

}
