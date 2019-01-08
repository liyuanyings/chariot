package com.example.demo.common;

public abstract class RegularExpression {

    /**
     * 用户名
     */
    public static final String ACCOUNT = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 邮箱
     */
    public static final String EMAIL = "^[a-z_0-9.-]{1,64}@([a-z0-9-]{1,200}.){1,5}[a-z]{1,6}$";

    /**
     * 手机号
     */
    public static final String CELLPHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 密码
     */
    public static final String PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    public static final String ZH_CN =  "[\u4e00-\u9fa5]{2,10}";
}

