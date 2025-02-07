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
import com.curtis.quickstart.domain.dto.BookDto;
import com.curtis.quickstart.domain.entities.BookEntity;
import com.curtis.quickstart.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

	
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	
	private BookService bookService;

	@Autowired
	public BookControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
		super();
		this.mockMvc = mockMvc;
		this.objectMapper = new ObjectMapper();
		this.bookService = bookService;
	}
	
	
	@Test
	public void testThatCreateBookReturnsHttpStatus201Created() throws Exception{
		
		BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
		String createBookJson = objectMapper.writeValueAsString(bookDto);
		
		mockMvc.perform(
				MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
				.contentType(MediaType.APPLICATION_JSON)
				.content(createBookJson)
					).andExpect(
							MockMvcResultMatchers.status().isCreated()
							);
		
	}
	
	@Test
	public void testThatCreateBookReturnsCreatedBook() throws Exception{
		
		BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
		String createBookJson = objectMapper.writeValueAsString(bookDto);
		
		mockMvc.perform(
				MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
				.contentType(MediaType.APPLICATION_JSON)
				.content(createBookJson)
					).andExpect(
							MockMvcResultMatchers.jsonPath("$.isbn").value(bookDto.getIsbn())
							).andExpect(
									MockMvcResultMatchers.jsonPath("$.title").value(bookDto.getTitle())
									);
		
	}
	
	@Test
	public void testThatListBookReturnsHttpStatus200Ok() throws Exception{
		
		BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
		String createBookJson = objectMapper.writeValueAsString(bookDto);
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/books")
				.contentType(MediaType.APPLICATION_JSON)
					).andExpect(
							MockMvcResultMatchers.status().isOk()
							);
		
	}
	
	@Test
	public void testThatListBooksReturnsBook() throws Exception {
		
		BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
		bookService.createBook(testBookEntityA.getIsbn(), testBookEntityA);
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/books")
				.contentType(MediaType.APPLICATION_JSON)
					).andExpect(
							MockMvcResultMatchers.jsonPath("$[0].isbn").value("978-1-2345-6789-0")
							).andExpect(
									MockMvcResultMatchers.jsonPath("$[0].title").value("The Shadow in the Attic")
									);
		
	}
	
}
