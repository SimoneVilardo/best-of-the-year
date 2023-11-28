package org.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

	@GetMapping("/")
	public String test3(Model model) {
		
		// .... data from db
		
		final String username = "Simone";
		
		model.addAttribute("username", username);
		
		return "page1";
	}	
	
}
