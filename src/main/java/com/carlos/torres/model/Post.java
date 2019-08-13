package com.carlos.torres.model;

import java.io.Serializable;


public interface Post extends Jsonable, Serializable {	
	Long getId();
	void setId(Long id);	
	String getTittle();
	void setTittle(String tittle);	
	String getDescription();
	void setDescription(String description);	
}
