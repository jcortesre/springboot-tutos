package com.h2demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.h2demo.converters.LocalDateTimeConverter;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String body;
	@Column(columnDefinition = "TEXT")
	private String teaser;
	private String slug;

	// @Convert(converter = LocalDateTimeConverter.class) we can use it explicity
	// but it's not required.
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime postedOn;
	// Author
	@ManyToOne
	private Author author;

	public Post() {

	}

	public Post(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(LocalDateTime postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}

}
