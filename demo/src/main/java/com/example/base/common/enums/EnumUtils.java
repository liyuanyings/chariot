package com.example.base.common.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lichunqing
 */
public class EnumUtils {


    public static <E extends Enum<E> & IEnum> Map<String, String> getEnumMap(final Class<E> enumClass) {
        final Map<String, String> map = new LinkedHashMap<>();
        for(E e : enumClass.getEnumConstants()){
            map.put(String.valueOf(e.getCode()), e.getDescription());
        }
        return map;
    }

    public static <E extends Enum<E> & IEnum> E getEnumByName(final Class<E> enumClass, final String enumName) {
        if (enumName == null) {
            return null;
        }
        try {
            return Enum.valueOf(enumClass, enumName);
        } catch (final IllegalArgumentException ex) {
            return null;
        }
    }

    public static <E extends Enum<E> & IEnum> E getEnumByCode(final Class<E> enumClass, final String code) {
        if (code == null) {
            return null;
        }
        for(E e : enumClass.getEnumConstants()){
            if(e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }

    public static <E extends Enum<E> & IEnum> E getEnumByDescription(final Class<E> enumClass, final String description) {
        if (description == null) {
            return null;
        }
        for(E e : enumClass.getEnumConstants()){
            if(e.getDescription().equals(description)){
                return e;
            }
        }
        return null;
    }

}
