package com.example.sys.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lichunqing
 */
@Data
@Accessors(chain = true)
public class SysDict implements Serializable {

    private Long id;

    private Long parentId;

    private String type;

    private String typeName;

    private String name;

    private String code;

    private String value;

    private Integer sort;

    private Integer status;
}
