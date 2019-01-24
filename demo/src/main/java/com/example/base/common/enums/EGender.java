package com.example.base.common.enums;

public enum EGender implements IEnum<Integer> {

    /**
     *
     */
    MALE(1, "男性"),

    FEMALE(2, "女性");

    private int code;

    private String description;

    EGender(final int code, final String description) {
        this.code = code;
        this.description = description;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
