#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.cache.local.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:20
 * @PackageName:${package}.base.cache.local.guava
 * @ClassName: LocalCacheFactory
 * @Description: 本地缓存工厂
 * @Version 1.0
 */
public class LocalCacheFactory {


    public static <K, V> Cache<K, V> getLocalCache() {
        return CacheBuilder.newBuilder().initialCapacity(1000).concurrencyLevel(16).expireAfterWrite(10, TimeUnit.SECONDS).build();
    }


}
