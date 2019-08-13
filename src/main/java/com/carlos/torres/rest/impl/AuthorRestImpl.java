package com.carlos.torres.rest.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.torres.model.impl.AuthorCto;
import com.carlos.torres.rest.AuthorRest;
import com.carlos.torres.service.AuthorService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AuthorRestImpl implements AuthorRest {
	
	@Autowired private AuthorService aService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<Void> postAuthor(@Valid @RequestBody final AuthorCto author) {
		log.info("Received request to 'postAuthor'...");
		ResponseEntity<Void> response;
		final AuthorCto savedAuthor = this.aService.saveAuthor(author);
		if(savedAuthor == null || savedAuthor.getId() == null) {			
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {			
			response = new ResponseEntity<>(HttpStatus.OK);
		}		
		return response;
	}

	@GetMapping("/{id}")
	@Override
	public Mono<AuthorCto> monoAuthor(@PathVariable final Long id) {
		log.info("Received request to 'monoAuthor'...");
		return this.aService.getAuthorById(id);
	}

	@GetMapping
	@Override
	public Flux<AuthorCto> fluxAuthor() {
		log.info("Received request to 'fluxAuthor'...");
		return this.aService.getAuthors();
	}
}