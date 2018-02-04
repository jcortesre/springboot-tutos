package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
