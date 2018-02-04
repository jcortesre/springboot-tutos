package com.restapi;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.restapi.domain.Author;
import com.restapi.domain.Post;
import com.restapi.repository.AuthorRepository;
import com.restapi.repository.PostRepository;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
		return args -> {

			Author dv = new Author();
			dv.setFirstName("Juan");
			dv.setLastName("Cortes");
			dv.setEmail("juan@teset.com");
			authorRepository.save(dv);

			Post post = new Post("Spring Boot Rocks!");
			post.setSlug("spring-data-rocks");
			post.setTeaser("Post Teaser");
			post.setBody("Post Body");
			post.setPostedOn(LocalDateTime.now());
			post.setAuthor(dv);
			postRepository.save(post);

			Post rest = new Post("REST is what all the cool kids are doing");
			rest.setSlug("rest-is-cool");
			rest.setTeaser("REST Teaser");
			rest.setBody("REST BODY");
			rest.setPostedOn(LocalDateTime.now());
			rest.setAuthor(dv);
			postRepository.save(rest);

		};
	}
}
