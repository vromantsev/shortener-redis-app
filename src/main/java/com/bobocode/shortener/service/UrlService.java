package com.bobocode.shortener.service;

public interface UrlService {

    String generateShortUrl(String originalUrl);

    String getOriginalUrl(String shortUrl);

}
