package com.carlos.torres.model.impl;

import java.io.Serializable;

import com.carlos.torres.model.Author;
import com.carlos.torres.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PostEntity implements Serializable, Post {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	private Author author;
	
	public PostEntity() {
		super();
	}

	public PostEntity(final Long id, final String title, final String description, final Author author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
	}

	@Override
	public final Long getId() {
		return id;
	}

	@Override
	public final void setId(final Long id) {
		this.id = id;
	}

	@Override
	public final String getTitle() {
		return title;
	}

	@Override
	public final void setTitle(final String title) {
		this.title = title;
	}

	@Override
	public final String getDescription() {
		return description;
	}

	@Override
	public final void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public Author getAuthor() {
		return author;
	}

	@Override
	public final void setAuthor(final Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public final boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostEntity other = (PostEntity) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public final String toString() {
		return new StringBuilder("PostEntity [")
		.append("id=").append(id)
		.append(", title=").append(title)
		.append(", description=").append(description)
		.append(", author=").append(author)
		.append("]")
		.toString();
	}
	
	@Override
	public final String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);		
	}
}
