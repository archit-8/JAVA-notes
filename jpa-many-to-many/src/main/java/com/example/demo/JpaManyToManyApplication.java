package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Post;
import com.example.demo.entity.Tag;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.TagRepo;

@SpringBootApplication
public class JpaManyToManyApplication implements CommandLineRunner{
	@Autowired
	PostRepo postrepo;
	@Autowired
	TagRepo tagpost;

	public static void main(String[] args) {
		 
		SpringApplication.run(JpaManyToManyApplication.class, args);
	}
	
    @Override
	public void run(String... args) throws Exception {
	    Post post = new Post(
	        "JPA Hibernate Many-to-Many Example with Spring Boot",
	        "Learning how to map a many-to-many relationship using JPA",
	        "Code example with Java"
	    );

	    Tag tag1 = new Tag("SpringBoot");
	    Tag tag2 = new Tag("JPA-Hibernate");
	    Tag tag3 = new Tag("Database");

	    post.getTags().add(tag1);
	    post.getTags().add(tag2);
	    post.getTags().add(tag3);

	    postrepo.save(post);

	    System.out.println("Post and tags saved successfully!");
	}


}
