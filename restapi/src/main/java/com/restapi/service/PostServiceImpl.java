package com.restapi.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.domain.Post;
import com.restapi.repository.AuthorRepository;
import com.restapi.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Iterable<Post> findAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		Post post = postRepository.findOne(id);
		return post;
	}

	@Override
	public void delete(long id) {
		postRepository.delete(id);
	}

	@Override
	@Transactional
	public Post create(Post post) {
		//if(post.getPostedOn() == null) {post.setPostedOn(LocalDateTime.now());}
		// save the new author
		authorRepository.save(post.getAuthor());
		return postRepository.save(post);
	}

	@Override
	public Post update(long id, Post update) {
		if(update.getPostedOn() == null) {update.setPostedOn(LocalDateTime.now());}
		Post post = postRepository.findOne(id);
		if (update.getTitle() != null) {
			post.setTitle(update.getTitle());
		}
		return postRepository.save(post);
	}
}
