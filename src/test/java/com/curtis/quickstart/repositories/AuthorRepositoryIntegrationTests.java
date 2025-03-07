package com.curtis.quickstart.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.curtis.quickstart.TestDataUtil;
import com.curtis.quickstart.domain.entities.AuthorEntity;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;
    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }
    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {

        AuthorEntity author = TestDataUtil.createTestAuthorEntityA();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }
    
    
    
    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3).
                containsExactly(authorA, authorB, authorC);
    }
    
    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorA);
        authorA.setName("UPDATED");
        underTest.save(authorA);
        Optional<AuthorEntity> result = underTest.findById(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }
    
    @Test
    public void testThatAuthorCanBeDeleted() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorA);
        underTest.deleteById(authorA.getId());
        Optional<AuthorEntity> result = underTest.findById(authorA.getId());
        assertThat(result).isEmpty();
    }
    
    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
    	
    	AuthorEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
    	underTest.save(testAuthorA);
    	AuthorEntity testAuthorB= TestDataUtil.createTestAuthorB();
    	underTest.save(testAuthorB);
    	AuthorEntity testAuthorC= TestDataUtil.createTestAuthorC();
    	underTest.save(testAuthorC);
    	
    	Iterable<AuthorEntity> result = underTest.ageLessThan(50);
    	assertThat(result).containsExactly(testAuthorB, testAuthorC);
    	
    	
    }
    
    @Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
    	
    	AuthorEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
    	underTest.save(testAuthorA);
    	AuthorEntity testAuthorB= TestDataUtil.createTestAuthorB();
    	underTest.save(testAuthorB);
    	AuthorEntity testAuthorC= TestDataUtil.createTestAuthorC();
    	underTest.save(testAuthorC);
    	
    	Iterable<AuthorEntity> result = underTest.findAuthorsWithAgeGreaterThan(50);
    	assertThat(result).containsExactly(testAuthorA);
    	
    	
    	
    }
    
}
