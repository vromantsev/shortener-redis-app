package com.bobocode.shortener.service;

import com.bobocode.shortener.entity.ShortToInitialUrl;
import com.bobocode.shortener.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SimpleUrlService implements UrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public String generateShortUrl(final String originalUrl) {
        Objects.requireNonNull(originalUrl);
        var shortUrl = RandomStringUtils.randomAlphanumeric(10);
        ShortToInitialUrl shortToInitialUrl = new ShortToInitialUrl(shortUrl, originalUrl);
        this.shortUrlRepository.save(shortToInitialUrl);
        return shortUrl;
    }

    @Override
    public String getOriginalUrl(final String shortUrl) {
        Objects.requireNonNull(shortUrl);
        return this.shortUrlRepository.findById(shortUrl)
                .map(ShortToInitialUrl::getInitialUrl)
                .orElseThrow();
    }
}
