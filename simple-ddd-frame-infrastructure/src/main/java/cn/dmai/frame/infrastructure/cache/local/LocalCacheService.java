package cn.dmai.frame.infrastructure.cache.local;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:18
 * @PackageName:cn.dmai.frame.base.cache.local
 * @ClassName: LocalCacheService
 * @Description: 本地缓存服务接口
 * @Version 1.0
 */
public interface LocalCacheService<K, V> {

    void put(K key, V value);

    V getIfPresent(Object key);

    void delete(Object key);
}
