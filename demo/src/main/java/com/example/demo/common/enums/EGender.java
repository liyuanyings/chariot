package com.example.demo.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @program: demo
 * @description:
 * @author: WT1124
 * @create: 2019-01-08 17:03
 **/
public enum EGender implements IEnum<Integer> {

    /**
     *
     */
    GenderEnum(1, "男性"),

    FEMALE(2, "女性");

    private int value;

    private String desc;

    EGender(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
