package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SysUser implements Serializable {

    private String id;

    private String account;

    private String password;

    private String displayName;

    private String realName;

    private String email;

    private String mobile;

    private String telephone;

    private Long orgId;

    private Integer type;

    private String gender;

    private String address;

    private String idCard;

    private Date createdTime;

    private Date updatedTime;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String description;
}
