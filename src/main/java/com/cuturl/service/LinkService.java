package com.cuturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cuturl.repository.LinkRepository;
import com.cuturl.model.Link;


@Service
public class LinkService {
	private LinkRepository linkRepository;
	
	@Autowired
	public void setLinkRepository(LinkRepository linkRepository)
	{
		this.linkRepository=linkRepository;
	}
	

	public void addUser(Link link)
	{
		linkRepository.save(link);
	}
}