package com.carlos.torres.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.torres.model.impl.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
