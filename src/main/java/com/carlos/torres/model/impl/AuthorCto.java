package com.carlos.torres.model.impl;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.carlos.torres.model.Author;
import com.carlos.torres.model.Jsonable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AuthorCto implements Jsonable, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String lastName;
	private List<PostDto> posts;
	
	public AuthorCto(final AuthorEntity author) {
		this.id = author.getId();
		this.name = author.getName();
		this.lastName = author.getLastName();
		if(author.getPosts()!=null && !author.getPosts().isEmpty()) {
			this.posts = author.getPosts().stream().map(PostDto::new).collect(Collectors.toList());			
		}		
	}

	@Override
	public String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
	}
}
