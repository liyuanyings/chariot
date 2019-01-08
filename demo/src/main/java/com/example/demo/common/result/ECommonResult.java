package com.example.demo.common.result;

public enum ECommonResult implements Result {

    /**
     *
     */
    SUCCESS("0000", "成功"),

    FORBIDDEN("403", "访问被禁止"),

    PAGE_NOT_FOUND("404", "当前页面不存在"),

    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),

    FAILED("9999", "失败");

    private final String retcode;

    private final String retmsg;

    ECommonResult(String retcode, String retmsg) {
        this.retcode = retcode;
        this.retmsg = retmsg;
    }

    @Override
    public String retcode() {
        return this.retcode;
    }

    @Override
    public String retmsg() {
        return this.retmsg;
    }
}
