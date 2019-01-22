package com.example.sys.cache;

import java.util.Iterator;
import java.util.Set;

import com.example.base.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.CacheManager;

/**
 * Cache工具类
 * @author lichunqing
 * @version 2013-5-29
 */
public class SysCacheHelper {

    private static Logger logger = LoggerFactory.getLogger(SysCacheHelper.class);

    private static CacheManager cacheManager = SpringContextUtils.getBean(CacheManager.class);



    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        return getCache(cacheName).get(getKey(key));
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object get(String cacheName, Object key, Object defaultValue) {
        Object value = get(cacheName, getKey(key));
        return value != null ? value : defaultValue;
    }

    /**
     * 写入缓存
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, Object key, Object value) {
        getCache(cacheName).put(getKey(key), value);
    }

    /**
     * 从缓存中移除
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(getKey(key));
    }


    /**
     * 从缓存中移除所有
     * @param cacheName
     */
    public static void removeAll(String cacheName) {
        Cache<Object, Object> cache = getCache(cacheName);
        cache.removeAll();
    }

    /**
     * 获取缓存键名，多数据源下增加数据源名称前缀
     * @param key
     * @return
     */
    private static String getKey(Object key){
        return (String) key;
    }

    /**
     * 获得一个Cache，没有则显示日志。
     * @param cacheName
     * @return
     */
    private static Cache<Object, Object> getCache(String cacheName){
        Cache<Object, Object> cache = cacheManager.getCache(cacheName);
        if (cache == null){
            throw new RuntimeException("当前系统中没有定义“"+cacheName+"”这个缓存。");
        }
        return cache;
    }

}