package com.example.sys.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.sys.model.entity.SysOrg;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@CacheConfig(cacheNames = "sys_org")
public interface SysOrgService {

    /**
     * 组织机构创建，创建完成之后添加到缓存
     * @param org
     * @return
     */
    @CachePut(key = "#result.id")
    SysOrg create(SysOrg org);

    /**
     * 组织机构的获取
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    SysOrg get(Long id);

    /**
     * 组织机构的更新
     * @param org
     * @return
     */
    @CachePut(key = "#result.id")
    SysOrg update(SysOrg org);

    /**
     * 获取全部组织机构
     * @return
     */
    List<SysOrg> list();

    /**
     * 组织机构的获取
     * @param orgIds
     * @return
     */
    List<SysOrg> list(List<Long> orgIds);

    /**
     * OnLevel结尾表示只查一个层级
     * @param orgId
     * @return
     */
    List<SysOrg> listOnLevel(Long orgId);

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
    List<SysOrg> listInDepth(Long orgId);

    /**
     * 分页查询
     * @param name
     * @param parentId
     * @return
     */
    IPage<SysOrg> page(String name, Long parentId, IPage<SysOrg> page);
}