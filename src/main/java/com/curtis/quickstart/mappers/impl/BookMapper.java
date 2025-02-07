package com.curtis.quickstart.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.curtis.quickstart.domain.dto.BookDto;
import com.curtis.quickstart.domain.entities.BookEntity;
import com.curtis.quickstart.mappers.Mapper;

@Component

public class BookMapper implements Mapper<BookEntity, BookDto> {
	
	private ModelMapper modelMapper;
	
	

	public BookMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public BookDto mapTo(BookEntity book) {
		// TODO Auto-generated method stub
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public BookEntity mapFrom(BookDto bookDto) {
		// TODO Auto-generated method stub
		return modelMapper.map(bookDto, BookEntity.class);
	}
	
	

}
