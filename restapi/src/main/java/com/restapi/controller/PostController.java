package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.domain.Post;
import com.restapi.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Post> findAll() {
		return postService.findAllPosts();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Post create(@RequestBody Post post) {
		return postService.create(post);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Post read(@PathVariable(value = "id") long id) {
		return postService.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
		return postService.update(id, post);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") int id) {
		postService.delete(id);
	}
}
