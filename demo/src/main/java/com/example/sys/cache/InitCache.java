package com.example.sys.cache;

import com.example.sys.model.entity.SysOrg;
import com.example.sys.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 在系统初始化的时候加载缓存
 * @author lichunqing
 */
@Component
public class InitCache implements CommandLineRunner {

    private final CacheManager cacheManager;

    private final SysOrgService sysOrgService;

    @Autowired
    public InitCache(SysOrgService sysOrgService, CacheManager cacheManager) {
        this.sysOrgService = sysOrgService;
        this.cacheManager = cacheManager;
    }

    @Override
    public void run(String... args) throws Exception {
        MutableConfiguration<Long, SysOrg> configuration = new MutableConfiguration<>();
        configuration.setTypes(Long.class, SysOrg.class)
                .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ETERNAL))
                .setStatisticsEnabled(true);
        Cache<Long, SysOrg> sysOrgCache = cacheManager.createCache("sys_org", configuration);
        List<SysOrg> sysOrgList = sysOrgService.list();
        sysOrgCache.putAll(sysOrgList.stream().collect(Collectors.toMap(SysOrg::getId, Function.identity())));
    }
}
