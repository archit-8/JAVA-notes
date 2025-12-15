package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testhello")
public class TestJSPController {
	
	
	@GetMapping("/send")
	public String method() {
	ArrayList<Integer> salaris=new ArrayList<>(Arrays.asList(3342342,334432,3243,3324,342342,342));
	
	return "hello";
	}

}
