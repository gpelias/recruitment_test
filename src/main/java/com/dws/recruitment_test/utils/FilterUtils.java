package com.dws.recruitment_test.utils;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.util.FieldUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class FilterUtils {

    private final SortUtils sortUtils;

    List<String> excludedKeys = List.of(
            "sort",
            "order"
    );

    public @NonNull <T> List<T> getList(Map<String, String> params, Stream<T> stream) {
        String sort = params.getOrDefault("sort", "name");
        String order = params.getOrDefault("order", "asc");

        Map<String, String> filters = this.getFilters(params);

        if (!filters.isEmpty()) stream = stream.filter(object -> this.applyFilters(object, filters));

        stream = stream.sorted((o1, o2) -> sortUtils.getField(o1, o2, sort, order));

        return stream.toList();
    }

    private boolean applyFilters(Object object, Map<String, String> filters) {
        return filters
                .entrySet()
                .stream()
                .allMatch(entry -> {
                    try {
                        String fieldValue = String.valueOf(FieldUtils.getFieldValue(object, entry.getKey())).toLowerCase();
                        String searchTerm = entry.getValue().toLowerCase();

                        return fieldValue.contains(searchTerm);
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                });
    }

    private Map<String, String> getFilters(Map<String, String> params) {
        return params
                .entrySet()
                .stream()
                .filter(e -> !excludedKeys.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
