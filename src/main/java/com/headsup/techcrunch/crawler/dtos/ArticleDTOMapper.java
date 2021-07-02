package com.headsup.techcrunch.crawler.dtos;

import com.headsup.techcrunch.crawler.model.Article;

public class ArticleDTOMapper {

    public static ArticleDTO toDTO(Article article){
        return ArticleDTO.builder()
                .authorName(article.getAuthor().getName())
                .title(article.getTitle())
                .content(article.transformContent())
                .build();
    }
}
