package com.dws.recruitment_test.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.PolyNull;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class AbstractCacheService<K, V> implements CacheService<K, V> {

    protected Cache<@NonNull K, V> cache;

    protected AbstractCacheService() {
        cache = Caffeine
                .newBuilder()
                .evictionListener(this.beforeRemove())
                .expireAfterAccess(15, TimeUnit.MINUTES)
                .build();
    }

    @Scheduled(fixedRate = 15 * 60 * 1000)
    private void verify() {
        cache.cleanUp();
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public V get(K key, Function<? super K, ? extends @PolyNull V> mappingFunction) {
        return cache.get(key, mappingFunction);
    }

    @Override
    public void remove(K key) {
        cache.invalidate(key);
    }

    @Override
    public RemovalListener<@NonNull K, @NonNull V> beforeRemove() {
        return (key, value, cause) -> {
        };
    }

}
