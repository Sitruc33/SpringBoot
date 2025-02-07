package com.curtis.quickstart.services;

import java.util.List;
import java.util.Optional;

import com.curtis.quickstart.domain.entities.AuthorEntity;

public interface AuthorService {

	AuthorEntity createAuthor(AuthorEntity author);

	List<AuthorEntity> findAll();
	
	

	Optional<AuthorEntity> findOne(Long id);
}
