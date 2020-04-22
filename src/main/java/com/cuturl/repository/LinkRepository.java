package com.cuturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuturl.model.Link;;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

	Link findFistByLongURL(String longURL);
	Link findFistByCode(String code);
	Link deleteBylongURL(String longURL);
}
