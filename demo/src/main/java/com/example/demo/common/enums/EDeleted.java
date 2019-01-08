package com.example.demo.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum EDeleted implements IEnum<Integer> {

    // 删除标记
    NOT_DELETED(0, "未删除"),

    DELETED(1, "已删除");

    private int value;

    private String desc;

    EDeleted(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return null;
    }
}
