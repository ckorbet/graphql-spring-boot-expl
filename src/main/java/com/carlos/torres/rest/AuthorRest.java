package com.carlos.torres.rest;

import org.springframework.http.ResponseEntity;

import com.carlos.torres.model.Author;
import com.carlos.torres.model.impl.AuthorCto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorRest {	
	ResponseEntity<Void> postAuthor(AuthorCto author);	
	Mono<AuthorCto> monoAuthor(Long id);	
	Flux<AuthorCto> fluxAuthor();
}