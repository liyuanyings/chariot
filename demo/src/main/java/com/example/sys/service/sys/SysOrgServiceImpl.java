package com.example.sys.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.mapper.SysOrgMapper;
import com.example.sys.model.SysOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

//    @Autowired
//    public SysOrgServiceImpl(SqlSession sqlSession) {
//        this.sysOrgMapper = sqlSession.getMapper(SysOrgMapper.class);
//    }

    @Override
    public List<SysOrg> list() {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> list(List<String> orgIds) {
        return null;
    }

    @Override
    public List<SysOrg> listFirstLevel(String orgId) {
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentId", orgId);
        return sysOrgMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysOrg> listInDepth() {
        return null;
    }

    @Override
    public List<SysOrg> listInDepth(String orgId) {
        return null;
    }
}