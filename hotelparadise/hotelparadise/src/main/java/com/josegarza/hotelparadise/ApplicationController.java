package com.josegarza.hotelparadise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	
	@GetMapping("/home")
	public String goHome() {
		return "menu-inicio";
	}
	
	@GetMapping("/login")
	public String login() {
		return "menu-login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "menu-login";
	}
	
}
