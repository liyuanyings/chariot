package com.example.base.common.enums;

/**
 * 自定义枚举结构，配合
 * @param <T>
 */
public interface IEnum<T> {

    T getCode();

    String getDescription();

}