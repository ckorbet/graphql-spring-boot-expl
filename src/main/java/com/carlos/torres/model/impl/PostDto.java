package com.carlos.torres.model.impl;

import java.io.Serializable;

import com.carlos.torres.model.Jsonable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PostDto implements Serializable, Jsonable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tittle;
	private String description;
	
	/**
	 * Constructor to facilitate DTO-to-Entity and Entity-to-DTO transformations
	 * @param post
	 */
	public PostDto(final PostEntity post) {
		this.id = post.getId();
		this.tittle = post.getTittle();
		this.description = post.getDescription();
	}
	
	@Override
	public String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
	}
}
