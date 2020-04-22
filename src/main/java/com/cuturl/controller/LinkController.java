package com.cuturl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
	@GetMapping("/")
	String home()
	{
		return "index";
	}
	
	@PostMapping("/generate")
	String generate()
	{
		return "index";
	}
	
	@GetMapping("/")
	String redirecting(@RequestParam String link)
	{
		return "redirect";
	}
	

}
