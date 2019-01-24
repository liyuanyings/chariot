package com.example.base.common.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>
 * 枚举处理工具类
 * </p>
 *
 * @author hubin
 * @since 2017-10-11
 */
public class EnumUtils {

    /**
     * <p>
     * 值映射为枚举
     * </p>
     *
     * @param enumClass 枚举类
     * @param value     枚举值
     * @param <E>       对应枚举
     * @return
     */
    public static <E extends Enum<?> & IEnum> E valueOf(Class<E> enumClass, Object value) {
        E[] es = enumClass.getEnumConstants();
        for (E e : es) {
            Object evalue = e.getValue();
            if (value instanceof Number && evalue instanceof Number
                && new BigDecimal(String.valueOf(value)).compareTo(new BigDecimal(String.valueOf(evalue))) == 0) {
                return e;
            }
            if (Objects.equals(evalue, value)) {
                return e;
            }
        }
        return null;
    }

    public static <E extends Enum<?>> E valueOf(Class<E> enumClass, Object value, Field enumField) {
        E[] es = enumClass.getEnumConstants();
        for (E e : es) {
            try {
                Object evalue = enumField.get(e);
                if (value instanceof Number && evalue instanceof Number
                    && new BigDecimal(String.valueOf(value)).compareTo(new BigDecimal(String.valueOf(evalue))) == 0) {
                    return e;
                }
                if (Objects.equals(evalue, value)) {
                    return e;
                }
            } catch (IllegalAccessException ignored) {

            }
        }
        return null;
    }

}
