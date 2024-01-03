#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.cache.local.guava;

import ${package}.base.constants.SystemConstants;
import ${package}.infrastructure.cache.local.LocalCacheService;
import com.google.common.cache.Cache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:19
 * @PackageName:${package}.base.cache.local.guava
 * @ClassName: GuavaLocalCacheService
 * @Description: 基于Guava实现的本地缓存
 * @Version 1.0
 */
@Component
@ConditionalOnProperty(name = "local.cache.type", havingValue = SystemConstants.GUAVA)
public class GuavaLocalCacheService<K, V> implements LocalCacheService<K, V> {

    //本地缓存，基于Guava实现
    private final Cache<K, V> cache = LocalCacheFactory.getLocalCache();


    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public V getIfPresent(Object key) {
        return cache.getIfPresent(key);
    }

    @Override
    public void delete(Object key) {
        cache.invalidate(key);
    }
}
