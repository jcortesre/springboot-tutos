package com.restapi.service;

import com.restapi.domain.Post;

public interface PostService {

	public Iterable<Post> findAllPosts();

	public Post findById(Long id);

	public void delete(long id);

	public Post create(Post post);

	public Post update(long id, Post update);

}
