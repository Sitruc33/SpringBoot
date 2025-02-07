package com.curtis.quickstart.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public BookEntity createUpdateBook(String isbn, BookEntity book) {
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
	
	

	@Override
	public Optional<BookEntity> findOne(String isbn) {
		// TODO Auto-generated method stub
		return bookRepository.findById(isbn);
	}

	@Override
	public boolean isExists(String isbn) {
		// TODO Auto-generated method stub
		return bookRepository.existsById(isbn);
	}

	@Override
    public BookEntity partialUpdate(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);

        return bookRepository.findById(isbn).map(existingBook -> {
            Optional.ofNullable(bookEntity.getTitle()).ifPresent(existingBook::setTitle);
            return bookRepository.save(existingBook);
        }).orElseThrow(() -> new RuntimeException("Book does not exist"));
    }

	@Override
	public void delete(String isbn) {
		bookRepository.deleteById(isbn);
		
	}

	@Override
	public Page<BookEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(pageable);
	}

	
	
	

}
