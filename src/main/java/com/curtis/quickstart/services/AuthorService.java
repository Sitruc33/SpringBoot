package com.curtis.quickstart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curtis.quickstart.domain.entities.AuthorEntity;

public interface AuthorService {

	AuthorEntity save(AuthorEntity author);

	List<AuthorEntity> findAll();
	
	Page<AuthorEntity> findAll(Pageable pageable);

	Optional<AuthorEntity> findOne(Long id);

	boolean isExists(Long id);

	AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

	void delete(Long id);
}
