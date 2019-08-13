package com.carlos.torres.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.carlos.torres.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POST")
@Data @NoArgsConstructor
public class PostEntity implements Post {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "post_id")
	private Long id;	
	@Column(name = "tittle")	
	private String tittle;	
	@Column(name = "description")
	private String description;	
	@ManyToOne
    @JoinColumn(name = "author_ref_id")
	private AuthorEntity author;
	
	/**
	 * Constructors to facilitate DTO-to-Entity and Entity-to-DTO transformations
	 * @param postDto
	 */
	public PostEntity(final PostDto postDto) {
		this.tittle = postDto.getTittle();
		this.description = postDto.getDescription();
	}
	
	@Override
	public final String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);		
	}
}
