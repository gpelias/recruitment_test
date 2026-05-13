package com.dws.recruitment_test.cache;

import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.PolyNull;

import java.util.function.Function;

public interface CacheService<K, V> {

    void put(K key, V value);

    V get(K key, Function<? super K, ? extends @PolyNull V> mappingFunction);

    void remove(K key);

    RemovalListener<K, V> beforeRemove();

}
