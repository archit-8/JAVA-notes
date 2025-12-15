package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.Book;
import com.example.demo.entity.Page;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.PageRepo;

@SpringBootApplication
public class NewProjectApplication {

	@Autowired
	PageRepo pageRepo;

	@Autowired
	BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(NewProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(BookRepo bookRepo, PageRepo pageRepo) {
		return (args) -> {
			Book book = new Book("Sprig", "Rod Johnson", "3444");
			Page p1 = new Page(1, "Introduction to java", "IOC dependecny", book);
			Page p65 = new Page(95, "java 8 content", "java", book);
			Page p95 = new Page(65, "springoot", "MVC Controller", book);
			book.getPages().add(p1);
			book.getPages().add(p95);
			book.getPages().add(p65);
			bookRepo.save(book);

			Book book1 = new Book("DSA", "Alfred", "33222");
			Page p23 = new Page(21, "Maps", "Bubbleshort", book1);

			book1.getPages().add(p23);
			bookRepo.save(book1);

			Iterable<Page> pages = pageRepo.findAll();
			for (Page p : pages) {
				System.out.println(p);
			}
		};
	}
}
