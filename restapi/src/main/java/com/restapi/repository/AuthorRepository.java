package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
