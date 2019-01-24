package com.example.sys.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lichunqing
 */
@Data
@Accessors(chain = true)
public class SysUser implements Serializable {

    private Long id;

    private String account;

    private String password;

    private String displayName;

    private Long orgId;

    private String realName;

    private String idCard;

    private String description;

    private String email;

    private String cellphone;

    private String telephone;

    private Integer gender;

    private String address;

    private Integer type;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;
}
