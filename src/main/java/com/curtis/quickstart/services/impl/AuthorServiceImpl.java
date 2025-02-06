package com.curtis.quickstart.services.impl;

import org.springframework.stereotype.Service;

import com.curtis.quickstart.domain.entities.AuthorEntity;
import com.curtis.quickstart.repositories.AuthorRepository;
import com.curtis.quickstart.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorRepository authorRepository;

	
	
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}




	public AuthorEntity createAuthor(AuthorEntity authorEntity) {
		return authorRepository.save(authorEntity);
		
	}
}
