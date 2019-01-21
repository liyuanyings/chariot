package com.example.sys.service.sys;

import com.example.sys.model.SysRole;

public interface SysRoleService {

    void create(SysRole role);

    SysRole get(long id);

    void update(SysRole role);

    void delete(long id);
}
