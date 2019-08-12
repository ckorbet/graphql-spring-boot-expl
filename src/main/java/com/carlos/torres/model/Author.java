package com.carlos.torres.model;

import java.util.List;

import com.carlos.torres.model.impl.PostEntity;

public interface Author extends Jsonable {

	Long getId();

	void setId(Long id);

	String getName();

	void setName(String name);

	String getLastName();

	void setLastName(String lastName);

	List<PostEntity> getPost();

	void setPost(List<PostEntity> post);
}