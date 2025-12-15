package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book implements Serializable {

	private String author;
	@Column(unique=true)
	private String isbn;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	String title;
	
	@OneToMany(mappedBy="book",fetch=FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Page> pages=new HashSet<>();
	
	

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public Book(String title, String author,  String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
