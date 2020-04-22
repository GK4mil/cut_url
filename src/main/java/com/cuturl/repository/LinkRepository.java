package com.cuturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuturl.model.Link;;

public interface LinkRepository extends JpaRepository<Link, Long> {

	Link findFistByLongURL(String longURL);
	Link findFistByCode(String code);
	Link deleteBylongURL();
}
