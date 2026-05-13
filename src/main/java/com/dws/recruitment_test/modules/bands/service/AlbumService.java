package com.dws.recruitment_test.modules.bands.service;

import com.dws.recruitment_test.cache.ListCacheService;
import com.dws.recruitment_test.modules.bands.dto.Album;
import com.dws.recruitment_test.modules.bands.integration.BandsIntegration;
import com.dws.recruitment_test.utils.FilterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AlbumService {

    private final BandsIntegration bandsIntegration;

    private final ListCacheService<Album> listCacheService;

    private final FilterUtils filterUtils;

    public List<Album> getAlbums(Map<String, String> params) {
        return filterUtils.getList(params, listCacheService.get("albums", (_) -> bandsIntegration.getAlbums()).stream());
    }

    public Album getAlbumById(UUID id) {
        return listCacheService.get("albums", (_) -> bandsIntegration.getAlbums())
                .stream()
                .filter(album -> id.equals(album.id()))
                .findFirst()
                .orElse(null);
    }

}