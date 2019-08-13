package com.carlos.torres.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.torres.model.impl.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
