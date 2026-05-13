package com.dws.recruitment_test.modules.bands.service;

import com.dws.recruitment_test.cache.ListCacheService;
import com.dws.recruitment_test.modules.bands.dto.Track;
import com.dws.recruitment_test.modules.bands.integration.BandsIntegration;
import com.dws.recruitment_test.utils.FilterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrackService {

    private final BandsIntegration bandsIntegration;

    private final ListCacheService<Track> listCacheService;

    private final FilterUtils filterUtils;

    public List<Track> getTracks(Map<String, String> params) {
        return filterUtils.getList(params, listCacheService.get("tracks", (_) -> bandsIntegration.getTracks()).stream());
    }

    public Track getTrackById(UUID id) {
        return listCacheService.get("tracks", (_) -> bandsIntegration.getTracks())
                .stream()
                .filter(band -> id.equals(band.id()))
                .findFirst()
                .orElse(null);
    }

}