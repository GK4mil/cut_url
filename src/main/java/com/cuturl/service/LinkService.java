package com.cuturl.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cuturl.repository.LinkRepository;
import com.cuturl.model.Link;

@Service
public class LinkService {
	private LinkRepository linkRepository;

	@Autowired
	public void setLinkRepository(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}

	public Link addLink(Link link, int count) {
		String code = codeGeneration(count);
		if (linkRepository.findFistByLongURL(link.getLongURL()) != null) {
			while (linkRepository.findFistByCode(code) != null) {
				code = codeGeneration(count);
			}
			return linkRepository.save(link);
		} else {
			return linkRepository.findFistByLongURL(link.getLongURL());
		}

	}

	private String codeGeneration(int count) {
		Random a = new Random();
		String code = "";
		for (int i = 0; i < count; i++) {
			switch (a.nextInt(3) + 1) {
			case 1:
				code += (char) a.nextInt(10) + 48;
				break;
			case 2:
				code += (char) a.nextInt(25) + 65;
				break;
			case 3:
				code += (char) a.nextInt(25) + 97;
				break;
			}
		}
		return code;
	}
}