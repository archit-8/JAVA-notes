
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TCSUSERDEC25")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username; 
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ROLE", nullable = false) 
	private String role;

	// g
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
