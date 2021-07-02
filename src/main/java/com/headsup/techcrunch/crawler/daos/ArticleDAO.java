package com.headsup.techcrunch.crawler.daos;

import com.headsup.techcrunch.crawler.model.Article;
import com.headsup.techcrunch.crawler.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ArticleDAO extends JpaRepository<Article, Long> {

    List<Article> findArticleByAuthorNameContainingIgnoreCase(String authorName);

}
