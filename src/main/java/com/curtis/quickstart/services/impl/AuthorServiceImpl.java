package com.curtis.quickstart.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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




	@Override
	public List<AuthorEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(authorRepository.findAll().spliterator(), false ).collect(Collectors.toList());
	}




	@Override
	public Optional<AuthorEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}
}
