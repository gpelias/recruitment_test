package com.dws.recruitment_test.utils;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class SortUtils {

    public int getField(Object o1, Object o2, String sort, String order) {
        try {
            Comparable val1 = (Comparable) this.getFieldValue(o1, sort);
            Comparable val2 = (Comparable) this.getFieldValue(o2, sort);

            if (val1 == null) return (val2 == null) ? 0 : -1;

            return val1.compareTo(val2) * ("asc".equals(order) ? 1 : -1);
        } catch (Exception e) {
            return 0;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);

        field.setAccessible(true);

        return field.get(object);
    }

}
