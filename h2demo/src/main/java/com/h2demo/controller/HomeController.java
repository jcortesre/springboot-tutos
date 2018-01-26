package com.h2demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2demo.domain.Post;
import com.h2demo.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService service;

	@RequestMapping("/")
	public String home(Model model) {
		Post post = service.findLastPost();
		model.addAttribute("post", post);
		return "index";
	}
}
