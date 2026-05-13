package com.dws.recruitment_test.modules.bands.dto;

import java.util.List;
import java.util.UUID;

public record Band(
        UUID id,
        String name,
        String image,
        String genre,
        Long numPlays,
        List<String> albums
) {
}
