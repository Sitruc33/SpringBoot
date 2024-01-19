package com.curtis.quickstart.dao;

import com.curtis.quickstart.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
