package com.bobocode.shortener.repository;

import com.bobocode.shortener.entity.ShortToInitialUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepository extends CrudRepository<ShortToInitialUrl, String> {
}
