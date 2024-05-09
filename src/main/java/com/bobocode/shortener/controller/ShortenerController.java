package com.bobocode.shortener.controller;

import com.bobocode.shortener.dto.CreateShortUrlRequest;
import com.bobocode.shortener.dto.CreateShortUrlResponse;
import com.bobocode.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
@RequiredArgsConstructor
public class ShortenerController {

    private final UrlService urlService;

    @PostMapping
    public ResponseEntity<CreateShortUrlResponse> shortenUrl(@RequestBody final CreateShortUrlRequest request) {
        String shortUrl = this.urlService.generateShortUrl(request.initialUrl());
        return ResponseEntity
                .created(URI.create(request.initialUrl()))
                .body(new CreateShortUrlResponse(shortUrl));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getInitialUrl(@PathVariable final String shortUrl) {
        String originalUrl = this.urlService.getOriginalUrl(shortUrl);
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(originalUrl))
                .body(originalUrl);
    }
}
