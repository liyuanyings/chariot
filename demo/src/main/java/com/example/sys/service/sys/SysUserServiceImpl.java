package com.example.sys.service.sys;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.sys.mapper.SysUserMapper;
import com.example.sys.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void create(SysUser user) {
        sysUserMapper.insert(user);
    }

    @Override
    public SysUser get(long id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public void update(SysUser user) {
        UpdateWrapper<SysUser> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        sysUserMapper.update(user, wrapper);
    }

    @Override
    public void delete(long id) {
        sysUserMapper.deleteById(id);
    }
}