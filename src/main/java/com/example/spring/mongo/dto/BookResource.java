package com.example.spring.mongo.dto;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public class BookResource implements RepresentationModelAssembler<BookDTO, EntityModel<BookDTO>>  {


	@Override
	public EntityModel<BookDTO> toModel(BookDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
