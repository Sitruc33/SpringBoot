package com.curtis.quickstart.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	@Override
    public List<BookEntity> findAll() {
        return StreamSupport
                .stream(
                        bookRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }

	
	
	

}
