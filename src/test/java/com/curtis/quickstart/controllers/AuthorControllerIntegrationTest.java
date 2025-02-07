package com.curtis.quickstart.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.curtis.quickstart.TestDataUtil;
import com.curtis.quickstart.domain.entities.AuthorEntity;
import com.curtis.quickstart.services.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {

	
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	private AuthorService authorService;

	@Autowired	
	public AuthorControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper, AuthorService authorService) {
		super();
		this.mockMvc = mockMvc;
		this.objectMapper = objectMapper;
		this.authorService = authorService;
	}
	
	@Test
	public void testThatCreateAuthorSuccessfullyReturnsHttp201Created() throws Exception {
		
		AuthorEntity testAuthorA = TestDataUtil.createTestAuthorA();
		testAuthorA.setId(null);
		String authorJson = objectMapper.writeValueAsString(testAuthorA);
		
		mockMvc.perform(
			MockMvcRequestBuilders.post("/authors")
			.contentType(MediaType.APPLICATION_JSON)
			.content(authorJson)
				).andExpect(
						MockMvcResultMatchers.status().isCreated()
						);
		
	}
	
	@Test
	public void testThatCreateAuthorSuccessfullyReturnsSavedAuthor() throws Exception {
		
		AuthorEntity testAuthorA = TestDataUtil.createTestAuthorA();
		testAuthorA.setId(null);
		String authorJson = objectMapper.writeValueAsString(testAuthorA);
		
		mockMvc.perform(
			MockMvcRequestBuilders.post("/authors")
			.contentType(MediaType.APPLICATION_JSON)
			.content(authorJson)
				).andExpect(
						MockMvcResultMatchers.jsonPath("$.id").isNumber()
						).andExpect(
								MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose")
								).andExpect(
										MockMvcResultMatchers.jsonPath("$.age").value("80")
										);
		
	}
	
	@Test
	public void testThatListAuthorsReturnsHttpStatus200() throws Exception {
		
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/authors")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(MockMvcResultMatchers.status().isOk());
				
		
	}
	
	@Test
	public void testThatListAuthorsReturnsListOfAuthors() throws Exception {
		
		
		AuthorEntity testAuthorEntityA = TestDataUtil.createTestAuthorA();
		authorService.createAuthor(testAuthorEntityA);
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/authors")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
						).andExpect(
								MockMvcResultMatchers.jsonPath("$[0].name").value("Abigail Rose")
								).andExpect(
										MockMvcResultMatchers.jsonPath("$[0].age").value("80")
										);
		
				
		
	}
	
	
}
