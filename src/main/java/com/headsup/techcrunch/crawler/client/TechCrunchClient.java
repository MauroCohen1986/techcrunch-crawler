package com.headsup.techcrunch.crawler.client;

import com.google.common.collect.Lists;

import com.headsup.techcrunch.crawler.exception.TechCrunchCrawlerException;
import com.mashape.unirest.http.Unirest;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TechCrunchClient {

  public List<TechCrunchArticle> getArticlesByPage(int page) {
    List<TechCrunchArticle> articles = Lists.newArrayList();
    try {
      Unirest.get(String.format("https://techcrunch.com/wp-json/wp/v2/posts?page=%s",page))
              .header("accept", "application/json")
              .asJson().getBody().getArray().forEach(object->{
        JSONObject jsonObject = (JSONObject)object;
        Long authorId = jsonObject.getLong("author");
        Optional<String> author = getAuthorNameById(jsonObject.getLong("author"));
        if(author.isPresent()){
          articles.add(TechCrunchArticle.builder()
                  .authorName(author.get())
                  .authorId(authorId)
                  .articleId(jsonObject.getLong("id"))
                  .content(jsonObject.getJSONObject("content").getString("rendered").toCharArray())
                  .title(jsonObject.getJSONObject("title").getString("rendered"))
                  .build());
        }
      });
    } catch (Exception e) {
      throw new TechCrunchCrawlerException("Could not fetch Articles.",e);
    }
    return articles;
  }

  private Optional<String> getAuthorNameById(long author) {
    Optional<String> result = Optional.empty();
    try {
      result = Optional.of(Unirest.get(String.format("https://techcrunch.com/wp-json/tc/v1/users/%s",author))
              .header("accept", "application/json")
              .asJson().getBody().getObject().getString("name"));
    } catch (Exception e) {
      log.error(String.format("Could not fetch Author Name for author with id:%s." ,author));
    }
    return result;
  }
}
