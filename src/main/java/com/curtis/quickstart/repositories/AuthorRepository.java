package com.curtis.quickstart.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.curtis.quickstart.domain.entities.AuthorEntity;
import com.curtis.quickstart.domain.entities.BookEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>, 
PagingAndSortingRepository<AuthorEntity, Long> {

	Iterable<AuthorEntity> ageLessThan(int age);
	
	@Query("Select a From AuthorEntity a where a.age > ?1")
	Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(int age);
	
}
