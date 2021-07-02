package com.headsup.techcrunch.crawler.crawlers;

import com.headsup.techcrunch.crawler.client.TechCrunchArticle;
import com.headsup.techcrunch.crawler.client.TechCrunchClient;
import com.headsup.techcrunch.crawler.daos.AuthorDAO;
import com.headsup.techcrunch.crawler.services.ArticleService;
import com.headsup.techcrunch.crawler.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CrawlerProcess {

  @Autowired
  private TechCrunchClient techCrunchClient;

  @Autowired
  private AuthorService authorService;

  @Autowired
  private ArticleService articleService;

  public void migrateArticles(int totalArticlesToMigrate) {
    int page=1;
    int migrated=0;
    log.info("Start Migration Process.");
    while(migrated<totalArticlesToMigrate){
      log.info("Retrieving page {} from tech crunch articles.",page);
      for(TechCrunchArticle techCrunchArticle : techCrunchClient.getArticlesByPage(page)){
        articleService.createArticle(
                authorService.getOrCreateAuthor(
                        techCrunchArticle.getAuthorId(),
                        techCrunchArticle.getAuthorName()),
                techCrunchArticle.getArticleId(),
                techCrunchArticle.getTitle(),
                techCrunchArticle.getContent());
        migrated++;
        if(migrated>= totalArticlesToMigrate)
          break;
      }
      page++;
      log.info("Total Migrated articles: {}", migrated);
    }
    log.info("End Migration Process.");
  }
}
