package com.project.model;

import javax.persistence.*;

@Entity
public class Book_Author {
	//Book-Author (id, book-id,  author-id)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	private Integer book_id;
	private Integer author_id;
	
	public Book_Author() {}
	
	public Book_Author(Integer book_id, Integer author_id) {
		super();
		this.book_id = book_id;
		this.author_id = author_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Book_Author [id=" + id + ", book_id=" + book_id + ", author_id=" + author_id + "]";
	}
	
	
	
	
}
