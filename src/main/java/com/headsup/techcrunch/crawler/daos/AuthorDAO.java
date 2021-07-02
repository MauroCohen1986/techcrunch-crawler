package com.headsup.techcrunch.crawler.daos;

import com.headsup.techcrunch.crawler.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {


}
