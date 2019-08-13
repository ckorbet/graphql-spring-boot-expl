package com.carlos.torres.model.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.carlos.torres.model.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTHOR")
@Data @NoArgsConstructor
public class AuthorEntity implements Author {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "author_id")
	private Long id;	
	@Column(name = "name")
	private String name;	
	@Column(name = "last_name")
	private String lastName;	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<PostEntity> posts;
	
	/**
	 * Constructor to facilitate CTO-to-Entity and Entity-to-CTO transformations
	 * @param authorCto
	 */
	public AuthorEntity(final AuthorCto author) {
		this.name = author.getName();
		this.lastName = author.getLastName();
		this.posts = author.getPosts().stream().map(PostEntity::new).collect(Collectors.toList());
		this.posts.forEach(post -> post.setAuthor(this));		
	}
	
	@Override
	public final String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);		
	}
}