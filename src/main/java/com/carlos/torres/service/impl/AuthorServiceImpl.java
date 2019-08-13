package com.carlos.torres.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.torres.model.impl.AuthorCto;
import com.carlos.torres.model.impl.AuthorEntity;
import com.carlos.torres.persistence.AuthorRepository;
import com.carlos.torres.persistence.PostRepository;
import com.carlos.torres.service.AuthorService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired private AuthorRepository aRepo;	
	@Autowired private PostRepository pRepo;

	@Override
	public AuthorCto saveAuthor(final AuthorCto inAuthor) {
		final AuthorEntity authorToSave = new AuthorEntity(inAuthor);
		final AuthorEntity saved = this.aRepo.save(authorToSave);
		if(saved.getId() == null || saved.getId().equals(inAuthor.getId())){
			log.info("Author duplicated. Author not saved. Post will not be saved");			
		} else {
			saved.setPosts(this.pRepo.saveAll(authorToSave.getPosts()));
			log.info("Author and Posts saved");
		}
		return new AuthorCto(saved);
	}

	@Override
	public Mono<AuthorCto> getAuthorById(final Long id) {
		final Optional<AuthorEntity> res = this.aRepo.findById(id);		
		return res.isPresent() ? Mono.just(new AuthorCto(res.get())) : null;
	}

	@Override
	public Flux<AuthorCto> getAuthors() {		
		return Flux.fromIterable(this.aRepo.findAll().stream().map(AuthorCto::new).collect(Collectors.toList()));
	}
}