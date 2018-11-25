package com.project.model;

import javax.persistence.*;

@Entity
public class Books {
	//Books (id, name, published, genre, rating)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	private String name;
	private String published;
	private String genre;
	private Integer rating;
	
	public Books() {}

	public Books(String name, String published, String genre, Integer rating) {
		this.name = name;
		this.published = published;
		this.genre = genre;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", published=" + published + ", genre=" + genre + ", rating="
				+ rating + "]";
	}
	
}
