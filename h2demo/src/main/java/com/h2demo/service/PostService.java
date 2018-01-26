package com.h2demo.service;

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
}
