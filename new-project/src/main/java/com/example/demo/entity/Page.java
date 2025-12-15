package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Page implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String chapter;
	String content;
	int number;
	public Page(int number,String chapter, String content,Book book) {
		super();
		this.number=number;
		this.chapter = chapter;
		this.content = content;
		this.book = book;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="book_id",nullable=false)
	private Book book;
	
	
	
}
