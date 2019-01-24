package com.example.sys.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lichunqing
 */
@Data
@Accessors(chain = true)
public class SysUserRole implements Serializable {

    private Long id;

    private Long userId;

    private Long roleId;
}