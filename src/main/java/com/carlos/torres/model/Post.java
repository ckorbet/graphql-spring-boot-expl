package com.carlos.torres.model;

public interface Post extends Jsonable{

	Long getId();

	void setId(Long id);

	String getTitle();

	void setTitle(String title);

	String getDescription();

	void setDescription(String description);

	Author getAuthor();

	void setAuthor(Author author);

}