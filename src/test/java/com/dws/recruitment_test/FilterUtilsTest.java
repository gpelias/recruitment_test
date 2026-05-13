package com.dws.recruitment_test;

import com.dws.recruitment_test.utils.FilterUtils;
import com.dws.recruitment_test.utils.SortUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FilterUtilsTest {

    private final SortUtils sortUtils = new SortUtils();

    private final FilterUtils filterUtils = new FilterUtils(sortUtils);

    record DummyBand(String name, String genre, int numPlays) {}

    @Test
    void shouldFilterAndSortListDynamically() {
        // Arrange: Criamos uma lista falsa de bandas
        Stream<DummyBand> stream = Stream.of(
                new DummyBand("Radiohead", "Rock", 200),
                new DummyBand("Lady Gaga", "Pop", 900),
                new DummyBand("Pink Floyd", "Rock", 300)
        );

        Map<String, String> params = Map.of(
                "genre", "rock",
                "sort", "numPlays",
                "order", "desc"
        );

        // Act: Rodamos a nossa classe utilitária
        List<DummyBand> result = filterUtils.getList(params, stream);

        // Assert: Verificamos se filtrou só Rock e ordenou do maior para o menor
        assertEquals(2, result.size(), "Deve retornar apenas 2 bandas de Rock");

        // Pink Floyd (300) deve vir antes de Radiohead (200)
        assertEquals("Pink Floyd", result.get(0).name());
        assertEquals("Radiohead", result.get(1).name());
    }

}
