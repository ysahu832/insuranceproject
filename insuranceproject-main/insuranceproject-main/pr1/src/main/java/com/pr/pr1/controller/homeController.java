package com.pr.pr1.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pr.pr1.model.User;
import com.pr.pr1.repo.UserRepo;
import com.pr.pr1.service.UserService;


@Controller
public class homeController {
	
	
	private final UserService userservice;
	homeController(UserService userservice){
		this.userservice=userservice;
	}
	
	
	@GetMapping("/")
	public String Homepage() {
		return "welcome" ;
	}
	
	@GetMapping("/login")
	public String loginw() {
		return "login";
	}
	@PostMapping("/login")
	public String dologin(@RequestParam String username,@RequestParam String password) {
		if (userservice.validateUser(username, password)) {
			System.out.println("yesssss");
			return "redirect:/Dashboard";
		}else {
			System.out.println("noooooooo");
		return "redirect:/login?error=true";}
	}
	
	
	
	@GetMapping("/Dashboard")
	public String DashBoard() {
		return "Dashboard";
	}
	
	@GetMapping("/register")
	public String RegUser(Model m) {
		m.addAttribute("NewUser", new User());
		return "register";
	}
	@PostMapping("/register")
	public String DOreg(User NewUser) {
		User Newus=userservice.registerUser(NewUser);
		return "redirect:/";
		
		
	}
	

}
