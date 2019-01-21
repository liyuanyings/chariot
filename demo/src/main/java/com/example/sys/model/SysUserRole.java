package com.example.sys.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SysUserRole implements Serializable {

    private Long id;

    private Long userId;

    private Long roleId;
}
