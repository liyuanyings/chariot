package com.example.sys.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lichunqing
 */
@Data
@Accessors(chain = true)
public class SysRole implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Integer status;
}
