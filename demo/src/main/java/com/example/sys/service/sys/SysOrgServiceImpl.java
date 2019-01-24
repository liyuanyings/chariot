package com.example.sys.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.base.common.Const;
import com.example.sys.mapper.SysOrgMapper;
import com.example.sys.model.entity.SysOrg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lichunqing
 */
@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

    @Override
    public SysOrg create(SysOrg org) {
        if(org.getParentId() == null){
            org.setPath(Const.SLASH);
        }else{
            org.setPath( this.buildSysOrgPath(org.getParentId()) );
        }
        sysOrgMapper.insert(org);
        return org;
    }

    @Override
    public SysOrg get(Long id) {
        return sysOrgMapper.selectById(id);
    }

    @Override
    public SysOrg update(SysOrg org) {
        // 如果传过来parentId不为空，则对path进行修改，否则默认不动
        if(org.getParentId() != null){
            org.setPath( this.buildSysOrgPath(org.getParentId()) );
        }
        sysOrgMapper.updateById(org);
        return sysOrgMapper.selectById(org.getId());
    }

    @Override
    public List<SysOrg> list() {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> list(List<Long> orgIds) {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", orgIds);
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> listOnLevel(Long orgId) {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentId", orgId);
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> listInDepth() {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> listInDepth(Long orgId) {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("path", orgId);
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<SysOrg> page(String name, Long parentId, IPage<SysOrg> page) {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(name)){
            queryWrapper.like("name", name);
        }
        if(parentId != null){
            queryWrapper.eq("parentId", parentId);
        }
        return sysOrgMapper.selectPage(page, queryWrapper);
    }

    private String buildSysOrgPath(long parentId){
        SysOrg parent = this.get(parentId);
        return parent.getPath() + parent.getId() + Const.SLASH;
    }
}