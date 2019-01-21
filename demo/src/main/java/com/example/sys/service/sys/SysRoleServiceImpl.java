package com.example.sys.service.sys;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.sys.mapper.SysRoleMapper;
import com.example.sys.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public void create(SysRole role) {
        sysRoleMapper.insert(role);
    }

    @Override
    public SysRole get(long id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public void update(SysRole role) {
        UpdateWrapper<SysRole> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", role);
        sysRoleMapper.update(role, wrapper);
    }

    @Override
    public void delete(long id) {
        sysRoleMapper.deleteById(id);
    }
}
