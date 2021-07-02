package com.headsup.techcrunch.crawler.controller;


import com.headsup.techcrunch.crawler.dtos.ArticleDTO;
import com.headsup.techcrunch.crawler.dtos.AuthorDTO;
import com.headsup.techcrunch.crawler.services.ArticleService;
import com.headsup.techcrunch.crawler.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;


@RestController
@Api(value="Author Controller")
@Log4j2
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @Autowired
  private ArticleService articleService;

  @RequestMapping(method = RequestMethod.GET,path = "/authors")
  @ApiOperation(value = "Get all existent authors.")
  public List<AuthorDTO> fetchAll() {
    List<AuthorDTO> result = authorService.getAllAuthors();
    return result;
  }


  @RequestMapping(method = RequestMethod.GET,path = "/author/{name}/articles")
  @ApiOperation(value = "Get articles by author name.")
  public List<ArticleDTO> fetchByAuthor(@NotNull @PathVariable(name = "name") String authorName) {
    return articleService.getArticlesByAuthorName(authorName);
  }

}
