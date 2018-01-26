package com.h2demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2demo.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService service;

	@RequestMapping("/list")
	public String home(Model model) {
		model.addAttribute("posts", service.findAllPosts());
		return "post/list";
	}
	
	@RequestMapping("/view/{slug}")
	public String view(@PathVariable("slug") String slug, Model model) {
		model.addAttribute("post", service.findBySlug(slug));
		return "post/view";
	}
}
