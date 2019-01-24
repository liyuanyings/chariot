package com.example.sys.service.sys;

import com.example.sys.model.entity.SysUser;

public interface SysUserService {

    void create(SysUser user);

    SysUser get(long id);

    void update(SysUser user);

    void delete(long id);
}