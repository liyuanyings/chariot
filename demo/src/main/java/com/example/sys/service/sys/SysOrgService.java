package com.example.sys.service.sys;

import com.example.sys.model.SysOrg;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@CacheConfig(cacheNames = "sys_org")
public interface SysOrgService {

    @CachePut(key = "#result.id")
    SysOrg create(SysOrg org);

    @Cacheable(key = "#id")
    SysOrg get(long id);

    @CachePut(key = "#result.id")
    SysOrg update(SysOrg org);

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
    List<SysOrg> listOnLevel(String orgId);

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