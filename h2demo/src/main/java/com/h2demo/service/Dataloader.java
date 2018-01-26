package com.h2demo.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2demo.domain.Author;
import com.h2demo.domain.Post;
import com.h2demo.repository.AuthorRepository;
import com.h2demo.repository.PostRepository;

@Service
public class Dataloader {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private PostRepository postRepository;

//	@PostConstruct
	private void loadData() {
		Author author = new Author("Juanc", "Yepes");
		authorRepository.save(author);

		Post post1 = new Post("Java is the best");
		post1.setAuthor(author);
		post1.setBody("post body here");
		post1.setPostedOn(LocalDateTime.now());
		postRepository.save(post1);

	}
}
