package com.dws.recruitment_test.modules.bands.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record Album(
        UUID id,
        String name,
        LocalDate releaseDate,
        String image,
        Band band,
        List<Track> tracks
) {
}
