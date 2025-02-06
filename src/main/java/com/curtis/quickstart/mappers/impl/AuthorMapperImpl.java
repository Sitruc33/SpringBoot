package com.curtis.quickstart.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.curtis.quickstart.domain.dto.AuthorDto;
import com.curtis.quickstart.domain.entities.AuthorEntity;
import com.curtis.quickstart.mappers.Mapper;

@Component

public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {
	
	private ModelMapper modelMapper;
	
	

	public AuthorMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public AuthorDto mapTo(AuthorEntity authorEntity) {
		// TODO Auto-generated method stub
		return modelMapper.map(authorEntity, AuthorDto.class);
	}

	@Override
	public AuthorEntity mapFrom(AuthorDto authorDto) {
		// TODO Auto-generated method stub
		return modelMapper.map(authorDto, AuthorEntity.class);
	}
	
	

}
