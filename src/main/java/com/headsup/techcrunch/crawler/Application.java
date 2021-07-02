package com.headsup.techcrunch.crawler;

import com.headsup.techcrunch.crawler.crawlers.CrawlerProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

  @Autowired
  CrawlerProcess crawlerProcess;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void runMigration(){
    crawlerProcess.migrateArticles(100);
  }
}
