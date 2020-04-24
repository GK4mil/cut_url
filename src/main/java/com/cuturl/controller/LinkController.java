package com.cuturl.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.cuturl.model.Link;
import com.cuturl.service.LinkService;


@Controller
public class LinkController {
	@Autowired
	private LinkService linkService;

	@PostMapping("/generate")
	String generate(@ModelAttribute Link link, Model model) {
		System.out.println("generating");
		linkService.addLink(link, 5);
		model.addAttribute("tinyURL", "localhost:8080/c/" + link.getCode());
		return "result";
	}

	@GetMapping("/")
	String home(Model model) {
		model.addAttribute("link", new Link());
		return "index";
	}
	

	@GetMapping("/c/{code}")
	String code(Model model,@PathVariable String code, HttpServletResponse httpServletResponse) {
		System.out.println(code.length());
		if (code.length() > 0) {
			System.out.println("code exists");
			return "redirect: /redirect";
		} else {
			System.out.println("no code");
			model.addAttribute("link", new Link());
			return "redirect:/";
		}
	}
	
	
//	@GetMapping("/test")
//	String test(Model model) {
//		model.addAttribute("code",linkService.codeGeneration(5));
//		return "test";
//	}

}
