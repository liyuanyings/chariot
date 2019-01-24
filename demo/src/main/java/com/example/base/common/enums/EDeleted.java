package com.example.base.common.enums;

public enum EDeleted implements IEnum<Integer> {

    // 删除标记
    NOT_DELETED(0, "未删除"),

    DELETED(1, "已删除");

    private int code;

    private String description;

    EDeleted(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
