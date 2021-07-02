package com.headsup.techcrunch.crawler.dtos;

import java.sql.Clob;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDTO {

    private String title;
    private String authorName;
    private String content;
}
