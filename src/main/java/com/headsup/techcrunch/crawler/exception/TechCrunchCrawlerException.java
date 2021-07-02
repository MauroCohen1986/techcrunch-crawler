package com.headsup.techcrunch.crawler.exception;

public class TechCrunchCrawlerException extends RuntimeException {

    public TechCrunchCrawlerException(String message, Exception e) {
        super(message,e);
    }
}
