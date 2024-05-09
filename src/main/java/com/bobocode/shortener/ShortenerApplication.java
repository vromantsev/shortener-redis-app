package com.bobocode.shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class ShortenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortenerApplication.class, args);
    }
}
