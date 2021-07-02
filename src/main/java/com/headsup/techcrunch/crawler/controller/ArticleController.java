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
@Api(value="Article Controller")
@Log4j2
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @RequestMapping(method = RequestMethod.GET,path = "/articles")
  @ApiOperation(value = "Get all existent articles.")
  public List<ArticleDTO> fetchAll() {
    return articleService.getAllArticles();
  }

}
