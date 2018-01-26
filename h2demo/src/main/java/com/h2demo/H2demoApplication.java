package com.h2demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.h2demo.repository.PostRepository;

@SpringBootApplication
public class H2demoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(H2demoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@PostConstruct
	void seePosts() {
		log.info("See post method called...");
		postRepository.findAll().forEach(c -> {
			log.info(c.toString());
		});
	}
}
