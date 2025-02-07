package com.curtis.quickstart.services;

import com.curtis.quickstart.domain.entities.BookEntity;

public interface BookService {
	
	BookEntity createBook(String isbn, BookEntity book);

}
