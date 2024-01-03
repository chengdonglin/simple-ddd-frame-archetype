#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.cache.service;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:14
 * @PackageName:${package}.base.cache.service
 * @ClassName: CacheService
 * @Description: 通用缓存接口
 * @Version 1.0
 */
public interface CacheService {

    /**
     * 构建缓存的key
     */
    String buildCacheKey(Object key);
}
