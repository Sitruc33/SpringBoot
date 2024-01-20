package com.curtis.quickstart.dao;

import com.curtis.quickstart.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
