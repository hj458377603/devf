package org.dream.utils.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

/**
 * 缓存工具
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service(value = "cacheUtil")
public class CacheUtils {
    private static Map<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();

    /**
     * 增加缓存
     * 
     * @param key
     * @param value
     * @param timeOutMilliSeconds
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void add(String key, Object value, long timeOutMilliSeconds) {
        Cache cache = new Cache(key, value, timeOutMilliSeconds + System.currentTimeMillis(), false);
        cacheMap.put(key, cache);
    }

    /**
     * 移除缓存
     * 
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public synchronized static boolean remove(String key) {
        if (cacheMap.containsKey(key)) {
            return cacheMap.remove(key) == null ? false : true;
        }
        return false;
    }

    /**
     * 查询缓存
     * 
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public synchronized static Cache getCache(String key) {
        if (hasCache(key)) {
            Cache cache = getCacheInfo(key);
            if (isExpired(cache)) { // 调用判断是否终止方法
                remove(key);
                return null;
            }
            return cache;
        } else
            return null;
    }

    /**
     * 更新缓存
     * 
     * @param key
     * @param value
     * @param timeOutMilliSeconds
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public synchronized static void update(String key, Object value, long timeOutMilliSeconds) {
        if (hasCache(key)) {
            remove(key);
            add(key, value, timeOutMilliSeconds);
        }
    }

    /**
     * 获取缓存大小
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public synchronized static int getCacheSize() {
        return cacheMap.size();
    }

    /**
     * 得到缓存。同步静态方法
     * 
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Cache getCacheInfo(String key) {
        return (Cache) cacheMap.get(key);
    }

    /**
     * 判断是否存在一个缓存
     * 
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private synchronized static boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }

    /**
     * 判断缓存是否过期
     * 
     * @param cache
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static boolean isExpired(Cache cache) {
        if (null == cache) { // 传入的缓存不存在
            return false;
        }
        long nowDt = System.currentTimeMillis(); // 系统当前的毫秒数
        long cacheDt = cache.getTimeOut(); // 缓存内的过期毫秒数
        if (cacheDt <= 0 || cacheDt > nowDt) { // 过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
            return false;
        } else { // 大于过期时间 即过期
            return true;
        }
    }
}
