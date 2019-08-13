package com.carlos.torres.resolvers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.torres.model.impl.AuthorCto;
import com.carlos.torres.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import reactor.core.publisher.Flux;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired private AuthorService aService;
	
	public Query(AuthorService aService) {
        this.aService = aService;
    }
	
	public final List<AuthorCto> authors() {
		final Flux<AuthorCto> authors = this.aService.getAuthors();
		final List<AuthorCto> resList = new ArrayList<>();
		if(authors != null) {
			authors.map(author -> resList.add(author));
		}
		return resList;
	}
}