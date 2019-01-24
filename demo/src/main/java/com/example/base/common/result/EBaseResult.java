package com.example.base.common.result;

import com.example.base.common.enums.IEnum;

public enum EBaseResult implements IEnum<String> {

    /**
     *
     */
    SUCCESS("0000", "成功"),

    FORBIDDEN("403", "访问被禁止"),

    PAGE_NOT_FOUND("404", "当前页面不存在"),

    SERVER_ERROR("500", "服务器内部错误"),

    FAILED("9999", "请求失败");

    private final String code;

    private final String description;

    EBaseResult(String code, String description) {
        this.code = code;
        this.description = description;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
