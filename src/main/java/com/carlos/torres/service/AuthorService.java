package com.carlos.torres.service;

import com.carlos.torres.model.impl.AuthorCto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorService {	
	AuthorCto saveAuthor(AuthorCto author);	
	Mono<AuthorCto> getAuthorById(Long id);	
	Flux<AuthorCto> getAuthors();
}