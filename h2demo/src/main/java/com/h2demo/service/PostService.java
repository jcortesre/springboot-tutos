package com.h2demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2demo.domain.Post;
import com.h2demo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findLastPost() {
		return repository.findFirstByOrderByPostedOnDesc();
	}

	public List<Post> findAllPosts() {
		return repository.findAllByOrderByPostedOnDesc();
	}

	public Post findBySlug(String slug) {
		return repository.findFirstBySlug(slug);
	}
}
