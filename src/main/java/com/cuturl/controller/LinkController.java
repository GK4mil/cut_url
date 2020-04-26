package com.cuturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cuturl.model.Link;
import com.cuturl.service.LinkService;

@Controller
public class LinkController {
	@Autowired
	private LinkService linkService;

	@PostMapping("/generate/start")
	String generate(@ModelAttribute Link link, Model model) {
		System.out.println("generating");
		if (!(link.getLongURL().contains("https://") || link.getLongURL().contains("http://")))
			link.setLongURL("http://" + link.getLongURL());
		linkService.addLink(link, 5);
		model.addAttribute("tinyURL", "localhost:8080/" + link.getCode());
		return "result";
	}

	@GetMapping("/")
	String home(Model model) {
		model.addAttribute("link", new Link());
		return "index";
	}

	@GetMapping("/{code}")
	String code(Model model, @PathVariable String code) {
		System.out.println(code.length());
		if (code.length() > 0) {
			System.out.println("code exists");
			return "redirect:" + linkService.getLink(code);
		} else
			return "redirect:/";
	}
}
