package com.curtis.quickstart.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curtis.quickstart.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Iterable<Author> ageLessThan(int age);
	
	@Query("Select a From Author a where a.age > ?1")
	Iterable<Author> findAuthorsWithAgeGreaterThan(int age);
	
}
