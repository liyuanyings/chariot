package com.example.sys.service.sys;

import com.example.sys.model.SysOrg;

import java.util.List;

public interface SysOrgService {

    List<SysOrg> list();

    /**
     *
     * @param orgIds
     * @return
     */
    List<SysOrg> list(List<String> orgIds);

    /**
     * OnLevel结尾表示只查一个层级
     * @param orgId
     * @return
     */
    List<SysOrg> listFirstLevel(String orgId);

    /**
     * InDepth结尾表示递归查询所有层级
     * @return
     */
    List<SysOrg> listInDepth();

    /**
     * InDepth结尾表示递归查询所有层级
     * @param orgId
     * @return
     */
    List<SysOrg> listInDepth(String orgId);
}