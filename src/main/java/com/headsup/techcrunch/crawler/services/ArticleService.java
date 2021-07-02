package com.headsup.techcrunch.crawler.services;

import com.headsup.techcrunch.crawler.daos.ArticleDAO;
import com.headsup.techcrunch.crawler.dtos.ArticleDTO;
import com.headsup.techcrunch.crawler.dtos.mappers.ArticleDTOMapper;
import com.headsup.techcrunch.crawler.model.Article;
import com.headsup.techcrunch.crawler.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialClob;

@Service
public class ArticleService {

  @Autowired
  private ArticleDAO articleDAO;

  public Article createArticle(Author author,Long id, String title, char[] content){
    Article article = new Article();
    article.setAuthor(author);
    article.setId(id);
    try {
      article.setContent(new SerialClob(content));
    } catch (SQLException throwables) {
      throw new RuntimeException("Problem creating clob");
    }
    article.setTitle(title);
    return articleDAO.save(article);
  }

  public List<ArticleDTO> getAllArticles() {
    return articleDAO.findAll()
            .stream()
            .map(article -> ArticleDTOMapper.toDTO(article))
            .collect(Collectors.toList());
  }

  public List<ArticleDTO> getArticlesByAuthorName(String authorName) {
    return articleDAO.findArticleByAuthorNameContainingIgnoreCase(authorName)
            .stream()
            .map(article -> ArticleDTOMapper.toDTO(article))
            .collect(Collectors.toList());
  }
}
