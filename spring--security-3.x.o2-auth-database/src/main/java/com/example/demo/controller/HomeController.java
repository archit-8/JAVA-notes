package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/root")
public class HomeController {
	@GetMapping("/all")
	public String CommanEndPoint() {
		return "welcome";
	}
	
	@GetMapping("/inbox")
	public String userEndPoint(HttpServletRequest request) {
		return "welcome User"+ request.getSession();
	}
	@GetMapping("/management")
	public String adminEndPoint() {
		return "welcome admin";
	}

}
