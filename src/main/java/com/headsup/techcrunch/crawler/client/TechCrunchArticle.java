package com.headsup.techcrunch.crawler.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechCrunchArticle {

    private Long authorId;
    private Long articleId;
    private String authorName;
    private String title;
    private char[] content;
}
