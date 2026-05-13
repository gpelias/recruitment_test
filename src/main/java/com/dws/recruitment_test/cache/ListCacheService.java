package com.dws.recruitment_test.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ListCacheService<T> extends AbstractCacheService<String, List<T>> {

    public ListCacheService() {
        cache = Caffeine
                .newBuilder()
                .evictionListener(this.beforeRemove())
                .expireAfterAccess(15, TimeUnit.MINUTES)
                .build();
    }

    public Cache<@NonNull String, List<T>> getCache() {
        return cache;
    }

}
