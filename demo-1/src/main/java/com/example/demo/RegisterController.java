package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	@Autowired
	UserRepository repository;

	@GetMapping("/signup")
	public String method() {
		return "registeration";

	}

	@PostMapping("/registeration")
	public String registerUser(@ModelAttribute User user, Model model) {
		
		System.out.println(user.getUserName());
		if (user.getUserName().length() > 8 && user.getPassword().length() > 8) {
			User newUser = repository.save(user);
			model.addAttribute("uid", newUser.getUserId());
			model.addAttribute("uname", newUser.getUserName());
			model.addAttribute("password", newUser.getPassword());

			return "success";
		} else
			return "registeration";

	}
}

//	@PostMapping("/registeration")
//	public String registerUser(@RequestParam String userName, @RequestParam String password) {
//		if(userName.length() >8&&password.length()>8) {
//			return "success";
//		}
//			else
//				return "registeration";
//		
//	
//	}
	




