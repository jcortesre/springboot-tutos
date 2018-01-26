package com.h2demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.h2demo.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

	// Find the latest blog post to display on the home page.
	Post findFirstByOrderByPostedOnDesc();

	List<Post> findAllByOrderByPostedOnDesc();

	Post findFirstBySlug(String slug);

}
