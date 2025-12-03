package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tag {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name;
	   
	 
	    public Tag(String name) {
		super();
		this.name = name;
	}


		@ManyToMany(fetch = FetchType.EAGER, 
	    		cascade = {CascadeType.PERSIST, 
	    				CascadeType.MERGE},
	    		mappedBy="tags"
	    		)
	    @JsonIgnore
	    private Set<Post> post=  new HashSet<>();
	    
	   
	    

}
