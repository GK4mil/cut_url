package com.cuturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuturl.model.Link;
import com.cuturl.service.LinkService;

@Controller
public class LinkController {
	@Autowired
	private LinkService linkService;

	@PostMapping("/generate")
	String generate(@ModelAttribute Link link, @RequestParam String longURL, Model model) {
		model.addAttribute("longURL", link.getLongURL());
		return "result";
	}

	@GetMapping("/{code}")
	String redirecting(Model model, @PathVariable String code) {

		if (code != null) {
			return "redirect:" + linkService.getLink(code);
		} else {
			model.addAttribute("link", new Link());
			return "index";
		}
	}

}
