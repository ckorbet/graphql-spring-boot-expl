package com.carlos.torres.model;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Jsonable {
	String toJSON() throws JsonProcessingException;
}
