package com.carlos.torres.model;

import java.io.Serializable;

public interface Author extends Serializable, Jsonable {	
	Long getId();
	void setId(Long id);	
	String getName();
	void setName(String name);	
	String getLastName();
	void setLastName(String lastName);	
}
