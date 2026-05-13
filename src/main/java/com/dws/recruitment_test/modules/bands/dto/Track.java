package com.dws.recruitment_test.modules.bands.dto;

import java.util.UUID;

public record Track(
        UUID id,
        String name,
        String duration,
        UUID album
) {
}
