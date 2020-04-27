package com.cuturl.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuturl.model.Link;
import com.cuturl.service.LinkService;

@RestController
public class LinkRestController {
	
	@Autowired
	private LinkService linkService;

	@RequestMapping(path="/api/read/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Link getLink(@PathVariable String code)
	{
		if (code.length() > 0) {
			return linkService.getObject(code);
		} else
			return null;
	}

}
