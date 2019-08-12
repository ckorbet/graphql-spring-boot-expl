package com.carlos.torres.model.impl;

import java.io.Serializable;
import java.util.List;

import com.carlos.torres.model.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AuthorEntity implements Serializable, Author {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String lastName;
	private List<PostEntity> post;
	
	public AuthorEntity() {
		super();
	}

	public AuthorEntity(final Long id, final String name, final String lastName, final List<PostEntity> post) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.post = post;
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
	public final String getName() {
		return name;
	}

	@Override
	public final void setName(final String name) {
		this.name = name;
	}

	@Override
	public final String getLastName() {
		return lastName;
	}

	@Override
	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Override
	public final List<PostEntity> getPost() {
		return post;
	}

	@Override
	public final void setPost(final List<PostEntity> post) {
		this.post = post;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
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
		AuthorEntity other = (AuthorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}

	@Override
	public final String toString() {
		return new StringBuilder("AuthorEntity [")
		.append("id=").append(id)
		.append(", name=").append(name)
		.append(", lastName=").append(lastName)
		.append(", post=").append(post)
		.append("]")
		.toString();
	}
	
	@Override
	public final String toJSON() throws JsonProcessingException {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);		
	}
}